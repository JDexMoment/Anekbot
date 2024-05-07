package io.javaProject.Anekbot.service;

import lombok.RequiredArgsConstructor;
import io.javaProject.Anekbot.model.Jokes;
import io.javaProject.Anekbot.repository.JokesRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class JokesServiceImpl implements JokesService {

    private final JokesRepository jokesRepository;

    @Override
    public void registerJokes(Jokes joke) {
        jokesRepository.save(joke);
    }

    @Override
    public Page<Jokes> getJokes(Pageable pageable) {
        return jokesRepository.findAll(pageable);
    }

    @Override
    public Optional<Jokes> getJokeById(Long id) {
        return jokesRepository.findById(id);
    }

    @Override
    public boolean deleteJokeById(Long id) {
        Optional<Jokes> joke = jokesRepository.findById(id);
        if (joke.isPresent()) {
            jokesRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public void putJokeById(Long id, Jokes updatedJoke) {
        Optional<Jokes> existingJoke = jokesRepository.findById(id);
        if (existingJoke.isPresent()) {
            existingJoke.get().setJoke(updatedJoke.getJoke());
            existingJoke.get().setDate_of_change(new Date());
            jokesRepository.save(existingJoke.get());
        }
    }

    @Override
    public Jokes getRandomJoke() {
        return jokesRepository.findRandomJoke();
    }

    @Override
    public Page<Jokes> getTopJokes(Pageable pageable) { return jokesRepository.findTop5ByOrderByJokesHistoryDesc(pageable); }

}
