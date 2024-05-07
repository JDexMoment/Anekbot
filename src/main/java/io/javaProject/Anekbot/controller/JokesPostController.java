package io.javaProject.Anekbot.controller;

import java.util.Date;

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
    ResponseEntity<Void> registerJokes(@RequestBody Jokes jokes) {
        jokes.setDate_of_birth(new Date());
        jokesService.registerJokes(jokes);
        return ResponseEntity.ok().build();
    }
}
