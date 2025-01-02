package ru.mirea.blog.graphql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import ru.mirea.blog.graphql.input.CreateUserInput;
import ru.mirea.blog.graphql.model.User;
import ru.mirea.blog.graphql.service.UserService;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @QueryMapping
    public List<User> users() {
        return userService.getUsers();
    }

    @QueryMapping
    public User user(@Argument Integer id) {
        return userService.getUser(id);
    }

    @MutationMapping
    public User createUser(@Argument CreateUserInput input) {
        return userService.createUser(input);
    }
}
