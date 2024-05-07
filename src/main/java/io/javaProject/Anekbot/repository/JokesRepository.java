package io.javaProject.Anekbot.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import io.javaProject.Anekbot.model.Jokes;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface JokesRepository extends JpaRepository<Jokes, Long> {
    @Query("SELECT j FROM jokes j ORDER BY RANDOM() LIMIT 1")
    Jokes findRandomJoke();

    Page<Jokes> findTop5ByOrderByJokesHistoryDesc(Pageable pageable);
}

