package io.javaProject.Anekbot.service;
import java.util.Optional;

import io.javaProject.Anekbot.model.Jokes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface JokesService {

    Optional<Jokes> getJokeById(Long id);

    Jokes getRandomJoke();

    void registerJokes(Jokes jokes);
    void putJokeById(Long id, Jokes jokes);

    boolean deleteJokeById(Long id);

    Page<Jokes> getJokes(Pageable pageable);
    Page<Jokes> getTopJokes(Pageable pageable);
}
