package ru.bvkuchin.securitytest.securitytest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bvkuchin.securitytest.securitytest.entities.User;
import ru.bvkuchin.securitytest.securitytest.services.UserServise;

import java.util.List;

@RestController

public class MainController {

    private UserServise userServise;

    @Autowired
    public void setUserServise(UserServise userServise) {
        this.userServise = userServise;
    }

    @GetMapping("/authenticated")
    public String authenticated() {
        return "authenticated";
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userServise.getUsers();
    }


}
