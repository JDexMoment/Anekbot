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
public class JokesController {

    private final JokesService jokesService;

    @PostMapping
    ResponseEntity<Jokes> registerJokes(@RequestBody Jokes jokes) {
        return ResponseEntity.ok(jokesService.registerJokes(jokes));
    }

    @GetMapping
    ResponseEntity<List<Jokes>> getJokes(){
        return ResponseEntity.ok(jokesService.getAllJokes());
    }

    @GetMapping("/{id}")
    ResponseEntity<Jokes> getJokeById(@PathVariable Long id){
        return jokesService.getJokeById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Jokes> deleteJokeById(@PathVariable Long id) {
        jokesService.deleteJokeById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Jokes> putJokeById(@PathVariable Long id, @RequestBody Map<String, String> body) {
        String newJoke = body.get("joke");
        jokesService.putJokeById(id, newJoke);
        return ResponseEntity.noContent().build();
    }

}
