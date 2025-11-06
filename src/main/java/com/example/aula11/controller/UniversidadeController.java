package com.example.aula11.controller;

import com.example.aula11.dto.UniversidadeCreateDTO;
import com.example.aula11.model.Universidade;
import com.example.aula11.service.UniversidadeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/universidades")
public class UniversidadeController {

    private final UniversidadeService universidadeService;

    public UniversidadeController(UniversidadeService universidadeService) {
        this.universidadeService = universidadeService;
    }

    @PostMapping
    public ResponseEntity<Universidade> createUniversidade(@RequestBody UniversidadeCreateDTO dto) {
        Universidade universidade = universidadeService.createUniversidade(dto);
        return new ResponseEntity<>(universidade, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Universidade>> getAllUniversidades() {
        List<Universidade> universidades = universidadeService.getAllUniversidades();
        return ResponseEntity.ok(universidades);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Universidade> getUniversidadeById(@PathVariable UUID id) {
        Universidade universidade = universidadeService.getUniversidadeById(id);
        if (universidade != null) {
            return ResponseEntity.ok(universidade);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Universidade> updateUniversidade(@PathVariable UUID id, @RequestBody UniversidadeCreateDTO dto) {
        Universidade universidade = universidadeService.updateUniversidade(id, dto);
        if (universidade != null) {
            return ResponseEntity.ok(universidade);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUniversidade(@PathVariable UUID id) {
        if (universidadeService.deleteUniversidade(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}