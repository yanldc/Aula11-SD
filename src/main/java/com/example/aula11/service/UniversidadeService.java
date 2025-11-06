package com.example.aula11.service;

import com.example.aula11.dto.UniversidadeCreateDTO;
import com.example.aula11.model.Universidade;
import com.example.aula11.repository.UniversidadeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UniversidadeService {

    private final UniversidadeRepository universidadeRepository;

    public UniversidadeService(UniversidadeRepository universidadeRepository) {
        this.universidadeRepository = universidadeRepository;
    }

    public List<Universidade> getAllUniversidades() {
        return universidadeRepository.findAll();
    }

    public Universidade getUniversidadeById(UUID id) {
        return universidadeRepository.findById(id).orElse(null);
    }

    public Universidade createUniversidade(UniversidadeCreateDTO dto) {
        Universidade universidade = new Universidade(
                dto.getNomeUniversidade(),
                dto.getSiglaUniversidade(),
                dto.getTipo());
        return universidadeRepository.save(universidade);
    }

    public Universidade updateUniversidade(UUID id, UniversidadeCreateDTO dto) {
        Universidade universidade = universidadeRepository.findById(id).orElse(null);
        if (universidade != null) {
            universidade.setNomeUniversidade(dto.getNomeUniversidade());
            universidade.setSiglaUniversidade(dto.getSiglaUniversidade());
            universidade.setTipo(dto.getTipo());
            return universidadeRepository.save(universidade);
        }
        return null;
    }

    public boolean deleteUniversidade(UUID id) {
        if (universidadeRepository.existsById(id)) {
            universidadeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}