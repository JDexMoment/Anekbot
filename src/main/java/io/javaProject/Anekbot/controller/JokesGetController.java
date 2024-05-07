package io.javaProject.Anekbot.controller;

import java.util.List;
import java.util.Map;


import lombok.RequiredArgsConstructor;
import io.javaProject.Anekbot.model.Jokes;
import io.javaProject.Anekbot.service.JokesService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/jokes")
public class JokesGetController {

    private final JokesService jokesService;

    @GetMapping
    public ResponseEntity<Page<Jokes>> getJokes(Pageable pageable) {
        return ResponseEntity.ok(jokesService.getJokes(pageable));
    }

    @GetMapping("/{id}")
    ResponseEntity<Jokes> getJokeById(@PathVariable Long id){
        return jokesService.getJokeById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/top")
    public ResponseEntity<Page<Jokes>> getTopJokes(Pageable pageable) {
        return ResponseEntity.ok(jokesService.getTopJokes(pageable));
    }

}
