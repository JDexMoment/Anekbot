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
public class JokesPutController {

    private final JokesService jokesService;

    @PutMapping("/{id}")
    ResponseEntity<Void> updateJoke(@PathVariable Long id, @RequestBody Jokes updatedJoke) {
        log.info("Updating joke with id {}", id);
        jokesService.putJokeById(id, updatedJoke);
        log.info("Successfully updated joke with id {}", id);
        return ResponseEntity.ok().build();
    }

}
