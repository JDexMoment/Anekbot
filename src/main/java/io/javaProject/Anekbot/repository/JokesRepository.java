package io.javaProject.Anekbot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import io.javaProject.Anekbot.model.Jokes;

import java.util.Optional;

public interface JokesRepository extends JpaRepository<Jokes, Long> {
    Optional<Jokes> getJokesById(Long id);
}

