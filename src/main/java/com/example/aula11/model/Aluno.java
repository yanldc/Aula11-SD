package com.example.aula11.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
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
    
    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;
    
    @ManyToOne
    @JoinColumn(name = "departamento_id")
    private Departamento departamento;
    
    @OneToOne(mappedBy = "aluno")
    private CarteiraEstudante carteiraEstudante;
    
    @ManyToMany
    @JoinTable(
        name = "aluno_funcionario",
        joinColumns = @JoinColumn(name = "aluno_id"),
        inverseJoinColumns = @JoinColumn(name = "funcionario_id")
    )
    private List<Funcionario> funcionarios;

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