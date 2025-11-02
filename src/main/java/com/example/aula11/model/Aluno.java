package com.example.aula11.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "alunos")
@Data
@NoArgsConstructor
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "BINARY(16)")
    private UUID idAluno;
    private String nomeCompleto;
    private LocalDate dataNascimento;
    private String cpfMatriculaNacional;
    private String matricula;
    private String emailInstitucional;
    private String telefone;

    // Construtor usado pelo DTO (sem o ID - será gerado pelo JPA)
    public Aluno(String nomeCompleto, LocalDate dataNascimento, String cpfMatriculaNacional, String matricula,
            String emailInstitucional, String telefone) {
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.cpfMatriculaNacional = cpfMatriculaNacional;
        this.matricula = matricula;
        this.emailInstitucional = emailInstitucional;
        this.telefone = telefone;
    }
}