package ru.bvkuchin.securitytest.securitytest.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bvkuchin.securitytest.securitytest.entities.Right;
import ru.bvkuchin.securitytest.securitytest.entities.Role;
import ru.bvkuchin.securitytest.securitytest.entities.User;
import ru.bvkuchin.securitytest.securitytest.repositories.UserRepository;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserServise implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).get();
        List<Role> userRoles = user.getRoles();
        List<Right> userRight = new ArrayList<>();

        for (Role role : userRoles) {
            for (Right right : role.getRights()) {
                userRight.add(right);
            }
        }

        log.info("---" + userRight + "---");

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), mapRoleToAuthority(userRight));

    }

    private Collection<? extends GrantedAuthority> mapRoleToAuthority(List<Right> rights) {
        return rights.stream().map(right -> new SimpleGrantedAuthority(right.getName())).collect(Collectors.toList());
    }


}
