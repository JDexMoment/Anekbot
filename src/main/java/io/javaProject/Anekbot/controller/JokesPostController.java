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
public class JokesPostController {

    private final JokesService jokesService;

    @PostMapping
    ResponseEntity<Jokes> registerJokes(@RequestBody Jokes jokes) {
        return ResponseEntity.ok(jokesService.registerJokes(jokes));
    }
}
