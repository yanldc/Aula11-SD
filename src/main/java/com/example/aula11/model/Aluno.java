package com.example.aula11.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
public class Aluno {
    private UUID idAluno;
    private String nomeCompleto;
    private LocalDate dataNascimento;
    private String cpfMatriculaNacional;
    private String matricula;
    private String emailInstitucional;
    private String telefone;

    // Construtor usado pelo DTO (sem o ID)
    public Aluno(String nomeCompleto, LocalDate dataNascimento, String cpfMatriculaNacional, String matricula,
            String emailInstitucional, String telefone) {
        this.idAluno = UUID.randomUUID();
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.cpfMatriculaNacional = cpfMatriculaNacional;
        this.matricula = matricula;
        this.emailInstitucional = emailInstitucional;
        this.telefone = telefone;
    }
}