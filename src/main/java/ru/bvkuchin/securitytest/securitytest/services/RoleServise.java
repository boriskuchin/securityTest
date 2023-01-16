package ru.bvkuchin.securitytest.securitytest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bvkuchin.securitytest.securitytest.entities.Role;
import ru.bvkuchin.securitytest.securitytest.entities.User;
import ru.bvkuchin.securitytest.securitytest.repositories.RolesRepository;
import ru.bvkuchin.securitytest.securitytest.repositories.UserRepository;

import java.util.List;

@Service
public class RoleServise {

    private RolesRepository roleRepository;

    @Autowired
    public void setRoleRepository(RolesRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> getUsers() {
        return roleRepository.findAll();
    }
}
