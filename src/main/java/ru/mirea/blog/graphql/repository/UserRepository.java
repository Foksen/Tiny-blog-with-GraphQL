package ru.mirea.blog.graphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mirea.blog.graphql.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
