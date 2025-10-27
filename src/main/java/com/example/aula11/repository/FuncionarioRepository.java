package com.example.aula11.repository;

import com.example.aula11.model.Funcionario;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class FuncionarioRepository {

    private final Map<UUID, Funcionario> database = new ConcurrentHashMap<>();

    public Funcionario save(Funcionario funcionario) {
        database.put(funcionario.getIdFuncionario(), funcionario);
        return funcionario;
    }

    public Optional<Funcionario> findById(UUID id) {
        return Optional.ofNullable(database.get(id));
    }

    public List<Funcionario> findAll() {
        return new ArrayList<>(database.values());
    }

    public void deleteById(UUID id) {
        database.remove(id);
    }
}