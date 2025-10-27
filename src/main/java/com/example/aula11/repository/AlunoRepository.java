package com.example.aula11.repository;

import com.example.aula11.model.Aluno;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class AlunoRepository {

    private final Map<UUID, Aluno> database = new ConcurrentHashMap<>();

    public Aluno save(Aluno aluno) {
        database.put(aluno.getIdAluno(), aluno);
        return aluno;
    }

    public Optional<Aluno> findById(UUID id) {
        return Optional.ofNullable(database.get(id));
    }

    public List<Aluno> findAll() {
        return new ArrayList<>(database.values());
    }

    public void deleteById(UUID id) {
        database.remove(id);
    }
}