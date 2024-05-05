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
public class JokesDeleteController {

    private final JokesService jokesService;

    @DeleteMapping("/{id}")
    ResponseEntity<Jokes> deleteJokeById(@PathVariable Long id) {
        jokesService.deleteJokeById(id);
        return ResponseEntity.noContent().build();
    }
}
