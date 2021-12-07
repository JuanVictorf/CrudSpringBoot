package com.mvteste.controllers;

import com.mvteste.models.Estabelecimento;
import com.mvteste.repositorys.EstabelecimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("estabelecimento")
public class EstabelecimentoController {

    @Autowired
    private EstabelecimentoRepository repository;

    @GetMapping
    public ResponseEntity<List<Estabelecimento>> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Estabelecimento> getById(@PathVariable String id) {
        Optional<Estabelecimento> estabelecimento = repository.findById(id);
        if (estabelecimento.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(estabelecimento.get());
    }

    @PostMapping
    public ResponseEntity<Estabelecimento> save(@RequestBody Estabelecimento estabelecimento) {
        return ResponseEntity.ok(repository.save(estabelecimento));
    }

    @PutMapping
    public ResponseEntity<Estabelecimento> edit(@RequestBody Estabelecimento estabelecimento){
        return ResponseEntity.ok(repository.save(estabelecimento));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable String id){
        repository.deleteById(id);
        return ResponseEntity.ok("Estabelecimento deletado.");
    }
}
