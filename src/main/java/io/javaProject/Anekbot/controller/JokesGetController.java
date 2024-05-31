package io.javaProject.Anekbot.controller;

import java.util.List;
import java.util.Map;


import lombok.RequiredArgsConstructor;
import io.javaProject.Anekbot.model.Jokes;
import io.javaProject.Anekbot.service.JokesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/jokes")
@Slf4j
public class JokesGetController {

    private final JokesService jokesService;

    @GetMapping
    public ResponseEntity<Page<Jokes>> getJokes(Pageable pageable) {
        log.info("Received GET request for jokes with pageable: {}", pageable);
        Page<Jokes> jokes = jokesService.getJokes(pageable);
        log.info("Returning {} jokes", jokes.getTotalElements());
        return ResponseEntity.ok(jokes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jokes> getJokeById(@PathVariable Long id) {
        log.info("Received GET request for joke with id {}", id);
        return jokesService.getJokeById(id)
                .map(joke -> {
                    log.info("Joke with id {} found", id);
                    return ResponseEntity.ok(joke);
                })
                .orElseGet(() -> {
                    log.warn("Joke with id {} not found", id);
                    return ResponseEntity.notFound().build();
                });
    }

    @GetMapping("/top")
    public ResponseEntity<Page<Jokes>> getTopJokes(Pageable pageable) {
        log.info("Received GET request for top jokes with pageable: {}", pageable);
        Page<Jokes> topJokes = jokesService.getTopJokes(pageable);
        log.info("Returning {} top jokes", topJokes.getTotalElements());
        return ResponseEntity.ok(topJokes);
    }
}
