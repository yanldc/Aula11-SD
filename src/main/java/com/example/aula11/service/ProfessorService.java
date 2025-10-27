package com.example.aula11.service;

import com.example.aula11.dto.ProfessorCreateDTO;
import com.example.aula11.model.Professor;
import com.example.aula11.repository.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public List<Professor> getAllProfessores() {
        return professorRepository.findAll();
    }

    public Professor getProfessorById(UUID id) {
        return professorRepository.findById(id).orElse(null);
    }

    public Professor createProfessor(ProfessorCreateDTO dto) {
        Professor professor = new Professor(
                dto.getNomeCompleto(),
                dto.getCpfRegistroFuncional(),
                dto.getEmailInstitucional(),
                dto.getTelefone(),
                dto.getTitulacao(),
                dto.getAreaDeAtuacao(),
                dto.getRegimeTrabalho());
        return professorRepository.save(professor);
    }

    public Professor updateProfessor(UUID id, ProfessorCreateDTO dto) {
        Professor professor = professorRepository.findById(id).orElse(null);
        if (professor != null) {
            professor.setNomeCompleto(dto.getNomeCompleto());
            professor.setCpfRegistroFuncional(dto.getCpfRegistroFuncional());
            professor.setEmailInstitucional(dto.getEmailInstitucional());
            professor.setTelefone(dto.getTelefone());
            professor.setTitulacao(dto.getTitulacao());
            professor.setAreaDeAtuacao(dto.getAreaDeAtuacao());
            professor.setRegimeTrabalho(dto.getRegimeTrabalho());
            return professorRepository.save(professor);
        }
        return null;
    }

    public boolean deleteProfessor(UUID id) {
        if (professorRepository.findById(id).isPresent()) {
            professorRepository.deleteById(id);
            return true;
        }
        return false;
    }
}