package io.javaProject.Anekbot.controller;

import java.util.List;
import java.util.Map;


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
public class JokesDeleteController {

    private final JokesService jokesService;

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteJokeById(@PathVariable Long id) {
        log.info("Received DELETE request for joke with id {}", id);
        if (jokesService.deleteJokeById(id)) {
            log.info("Joke with id {} successfully deleted", id);
            return ResponseEntity.ok().build();
        } else {
            log.warn("Joke with id {} not found", id);
            return ResponseEntity.notFound().build();
        }
    }
}
