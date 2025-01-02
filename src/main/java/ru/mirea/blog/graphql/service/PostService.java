package ru.mirea.blog.graphql.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mirea.blog.graphql.input.CreatePostInput;
import ru.mirea.blog.graphql.model.Post;
import ru.mirea.blog.graphql.repository.PostRepository;

import java.time.Instant;
import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserService userService;

    public Post createPost(CreatePostInput createPostInput) {
        var post = Post.builder()
                .text(createPostInput.text())
                .author(userService.getUser(createPostInput.userId()))
                .createdAt(Instant.now().toString())
                .build();
        return postRepository.save(post);
    }

    public Post getPost(Integer id) {
        return postRepository.findById(id).orElseThrow();
    }

    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    public List<Post> getPostsByUser(Integer id) {
        System.out.println(postRepository.findByAuthorId(id));
        return postRepository.findByAuthorId(id);
    }
}
