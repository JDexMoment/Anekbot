package io.javaProject.Anekbot.service;
import java.util.List;
import java.util.Optional;

import io.javaProject.Anekbot.model.Jokes;

public interface JokesService {

    Jokes registerJokes(Jokes jokes);
    List<Jokes> getAllJokes();
    Optional<Jokes> getJokeById(Long id);
    void deleteJokeById(Long id);
    void putJokeById(Long id, String joke);
}
