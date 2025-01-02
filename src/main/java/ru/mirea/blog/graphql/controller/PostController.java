package ru.mirea.blog.graphql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import ru.mirea.blog.graphql.input.CreatePostInput;
import ru.mirea.blog.graphql.model.Post;
import ru.mirea.blog.graphql.service.PostService;

import java.util.List;

@Controller
public class PostController {
    @Autowired
    private PostService postService;

    @QueryMapping
    public List<Post> posts() {
        return postService.getPosts();
    }

    @QueryMapping
    public Post post(@Argument Integer id) {
        return postService.getPost(id);
    }

    @QueryMapping
    public List<Post> postsByUser(@Argument Integer userId) {
        return postService.getPostsByUser(userId);
    }

    @MutationMapping
    public Post createPost(@Argument CreatePostInput input) {
        return postService.createPost(input);
    }
}
