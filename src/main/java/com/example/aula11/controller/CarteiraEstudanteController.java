package com.example.aula11.controller;

import com.example.aula11.dto.CarteiraEstudanteCreateDTO;
import com.example.aula11.model.CarteiraEstudante;
import com.example.aula11.service.CarteiraEstudanteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/carteiras")
public class CarteiraEstudanteController {

    private final CarteiraEstudanteService carteiraService;

    public CarteiraEstudanteController(CarteiraEstudanteService carteiraService) {
        this.carteiraService = carteiraService;
    }

    @PostMapping
    public ResponseEntity<CarteiraEstudante> createCarteira(@RequestBody CarteiraEstudanteCreateDTO dto) {
        CarteiraEstudante carteira = carteiraService.createCarteira(dto);
        return new ResponseEntity<>(carteira, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CarteiraEstudante>> getAllCarteiras() {
        List<CarteiraEstudante> carteiras = carteiraService.getAllCarteiras();
        return ResponseEntity.ok(carteiras);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarteiraEstudante> getCarteiraById(@PathVariable UUID id) {
        CarteiraEstudante carteira = carteiraService.getCarteiraById(id);
        if (carteira != null) {
            return ResponseEntity.ok(carteira);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarteiraEstudante> updateCarteira(@PathVariable UUID id, @RequestBody CarteiraEstudanteCreateDTO dto) {
        CarteiraEstudante carteira = carteiraService.updateCarteira(id, dto);
        if (carteira != null) {
            return ResponseEntity.ok(carteira);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarteira(@PathVariable UUID id) {
        if (carteiraService.deleteCarteira(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}