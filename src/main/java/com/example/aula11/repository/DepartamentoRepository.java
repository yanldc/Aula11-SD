package com.example.aula11.repository;

import com.example.aula11.model.Departamento;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class DepartamentoRepository {

    private final Map<UUID, Departamento> database = new ConcurrentHashMap<>();

    public Departamento save(Departamento departamento) {
        database.put(departamento.getIdDepartamento(), departamento);
        return departamento;
    }

    public Optional<Departamento> findById(UUID id) {
        return Optional.ofNullable(database.get(id));
    }

    public List<Departamento> findAll() {
        return new ArrayList<>(database.values());
    }

    public void deleteById(UUID id) {
        database.remove(id);
    }
}