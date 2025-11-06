package com.example.aula11.repository;

import com.example.aula11.model.Universidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface UniversidadeRepository extends JpaRepository<Universidade, UUID> {
}