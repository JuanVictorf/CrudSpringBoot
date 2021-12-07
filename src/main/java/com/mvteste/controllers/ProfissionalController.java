package com.mvteste.controllers;

import com.mvteste.models.Estabelecimento;
import com.mvteste.models.Profissional;
import com.mvteste.repositorys.ProfissionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("profissional")
public class ProfissionalController {

    @Autowired
    private ProfissionalRepository repository;

    @GetMapping
    public ResponseEntity<List<Profissional>> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Profissional> getById(@PathVariable String id) {
        Optional<Profissional> profissional = repository.findById(id);
        if (profissional.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(profissional.get());
    }

    @PostMapping
    public ResponseEntity<Profissional> save(@RequestBody Profissional profissional) {
        return ResponseEntity.ok(repository.save(profissional));
    }

    @PutMapping
    public ResponseEntity<Profissional> edit(@RequestBody Profissional profissional){
        return ResponseEntity.ok(repository.save(profissional));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable String id){
        repository.deleteById(id);
        return ResponseEntity.ok("Profissional deletado.");
    }
}
