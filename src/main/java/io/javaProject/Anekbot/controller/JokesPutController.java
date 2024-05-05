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
    public ResponseEntity<Jokes> putJokeById(@PathVariable Long id, @RequestBody Map<String, String> body) {
        String newJoke = body.get("joke");
        jokesService.putJokeById(id, newJoke);
        return ResponseEntity.noContent().build();
    }

}
