package com.example.aula11.controller;

import com.example.aula11.dto.DepartamentoCreateDTO;
import com.example.aula11.model.Departamento;
import com.example.aula11.service.DepartamentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/departamentos")
public class DepartamentoController {

    private final DepartamentoService departamentoService;

    public DepartamentoController(DepartamentoService departamentoService) {
        this.departamentoService = departamentoService;
    }

    @PostMapping
    public ResponseEntity<Departamento> createDepartamento(@RequestBody DepartamentoCreateDTO dto) {
        Departamento novoDepartamento = departamentoService.createDepartamento(dto);
        return new ResponseEntity<>(novoDepartamento, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Departamento>> getAllDepartamentos() {
        List<Departamento> departamentos = departamentoService.getAllDepartamentos();
        return ResponseEntity.ok(departamentos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Departamento> getDepartamentoById(@PathVariable UUID id) {
        Departamento departamento = departamentoService.getDepartamentoById(id);
        if (departamento != null) {
            return ResponseEntity.ok(departamento);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Departamento> updateDepartamento(@PathVariable UUID id, @RequestBody DepartamentoCreateDTO dto) {
        Departamento departamento = departamentoService.updateDepartamento(id, dto);
        if (departamento != null) {
            return ResponseEntity.ok(departamento);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartamento(@PathVariable UUID id) {
        if (departamentoService.deleteDepartamento(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}