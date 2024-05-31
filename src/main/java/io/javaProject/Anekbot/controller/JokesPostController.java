package io.javaProject.Anekbot.controller;

import java.util.Date;

import lombok.RequiredArgsConstructor;
import io.javaProject.Anekbot.model.Jokes;
import io.javaProject.Anekbot.service.JokesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/jokes")
@Slf4j
public class JokesPostController {

    private final JokesService jokesService;

    @PostMapping
    ResponseEntity<Void> registerJokes(@RequestBody Jokes jokes) {
        log.info("Received POST request to a joke: {}", jokes);
        jokes.setDate_of_birth(new Date());
        jokesService.registerJokes(jokes);
        log.info("Successfully registered a joke: {}", jokes);
        return ResponseEntity.ok().build();
    }
}
