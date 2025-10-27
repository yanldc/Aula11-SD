package com.example.aula11.repository;

import com.example.aula11.model.Professor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class ProfessorRepository {

    private final Map<UUID, Professor> database = new ConcurrentHashMap<>();

    public Professor save(Professor professor) {
        database.put(professor.getIdProfessor(), professor);
        return professor;
    }

    public Optional<Professor> findById(UUID id) {
        return Optional.ofNullable(database.get(id));
    }

    public List<Professor> findAll() {
        return new ArrayList<>(database.values());
    }

    public void deleteById(UUID id) {
        database.remove(id);
    }
}