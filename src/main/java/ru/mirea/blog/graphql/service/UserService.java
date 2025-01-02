package ru.mirea.blog.graphql.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mirea.blog.graphql.input.CreateUserInput;
import ru.mirea.blog.graphql.model.Post;
import ru.mirea.blog.graphql.model.User;
import ru.mirea.blog.graphql.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(CreateUserInput createUserInput) {
        var user = User.builder()
                .username(createUserInput.username())
                .password(createUserInput.password())
                .email(createUserInput.email())
                .build();
        return userRepository.save(user);
    }

    public User getUser(Integer id) {
        return userRepository.findById(id).orElseThrow();
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public List<Post> getUserPosts(Integer id) {
        return userRepository.findById(id).orElseThrow().getPosts();
    }
}
