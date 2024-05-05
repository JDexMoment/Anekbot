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
public class JokesGetController {

    private final JokesService jokesService;

    @GetMapping
    ResponseEntity<List<Jokes>> getJokes(){
        return ResponseEntity.ok(jokesService.getAllJokes());
    }

    @GetMapping("/{id}")
    ResponseEntity<Jokes> getJokeById(@PathVariable Long id){
        return jokesService.getJokeById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


}
