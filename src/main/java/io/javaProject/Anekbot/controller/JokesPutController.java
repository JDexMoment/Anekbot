package io.javaProject.Anekbot.controller;

import java.util.List;
import java.util.Map;


import lombok.RequiredArgsConstructor;
import io.javaProject.Anekbot.model.Jokes;
import io.javaProject.Anekbot.service.JokesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/jokes")
public class JokesPutController {

    private final JokesService jokesService;

    @PutMapping("/{id}")
    ResponseEntity<Void> updateJoke(@PathVariable Long id, @RequestBody Jokes updatedJoke) {
        jokesService.putJokeById(id, updatedJoke);
        return ResponseEntity.ok().build();
    }

}
