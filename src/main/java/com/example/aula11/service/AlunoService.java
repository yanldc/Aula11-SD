package com.example.aula11.service;

import com.example.aula11.dto.AlunoCreateDTO;
import com.example.aula11.model.Aluno;
import com.example.aula11.repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;

    // Injeção de dependência via construtor (recomendado)
    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public List<Aluno> getAllAlunos() {
        return alunoRepository.findAll();
    }

    public Aluno getAlunoById(UUID id) {
        return alunoRepository.findById(id).orElse(null);
    }

    public Aluno createAluno(AlunoCreateDTO dto) {
        Aluno aluno = new Aluno(
                dto.getNomeCompleto(),
                dto.getDataNascimento(),
                dto.getCpfMatriculaNacional(),
                dto.getMatricula(),
                dto.getEmailInstitucional(),
                dto.getTelefone());
        return alunoRepository.save(aluno);
    }

    public Aluno updateAluno(UUID id, AlunoCreateDTO dto) {
        Aluno aluno = alunoRepository.findById(id).orElse(null);
        if (aluno != null) {
            aluno.setNomeCompleto(dto.getNomeCompleto());
            aluno.setDataNascimento(dto.getDataNascimento());
            aluno.setCpfMatriculaNacional(dto.getCpfMatriculaNacional());
            aluno.setMatricula(dto.getMatricula());
            aluno.setEmailInstitucional(dto.getEmailInstitucional());
            aluno.setTelefone(dto.getTelefone());
            return alunoRepository.save(aluno);
        }
        return null;
    }

    public boolean deleteAluno(UUID id) {
        if (alunoRepository.findById(id).isPresent()) {
            alunoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}