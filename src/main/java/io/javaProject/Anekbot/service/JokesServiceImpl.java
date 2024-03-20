package io.javaProject.Anekbot.service;

import com.pengrad.telegrambot.TelegramBot;
import lombok.RequiredArgsConstructor;
import io.javaProject.Anekbot.model.Jokes;
import io.javaProject.Anekbot.repository.JokesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class JokesServiceImpl implements JokesService {

    private final JokesRepository jokesRepository;

    private final TelegramBot telegramBot;

    @Override
    public Jokes registerJokes(Jokes jokes) {
        return jokesRepository.save(jokes);
    }

    @Override
    public List<Jokes> getAllJokes() {
        return jokesRepository.findAll();
    }

    @Override
    public Optional<Jokes> getJokeById(Long id) {
        return jokesRepository.findById(id);
    }

    @Override
    public void deleteJokeById(Long id) {
        jokesRepository.deleteById(id);
    }

    @Override
    public void putJokeById(Long id, String newJoke) {
        Optional<Jokes> optionalJoke = jokesRepository.getJokesById(id);
        if (optionalJoke.isPresent()) {
            Jokes jokeToUpdate = optionalJoke.get();
            jokeToUpdate.setJoke(newJoke); // Устанавливаем новую шутку
            jokesRepository.save(jokeToUpdate);
        } else {
            throw new Error("Joke not found with id: " + id);
        }
    }

}
