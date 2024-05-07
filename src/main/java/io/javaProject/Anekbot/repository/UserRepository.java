package io.javaProject.Anekbot.repository;

import io.javaProject.Anekbot.model.User;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
