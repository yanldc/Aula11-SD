package com.example.aula11.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "professores")
@Data
@NoArgsConstructor
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "BINARY(16)")
    private UUID idProfessor;
    private String nomeCompleto;
    private String cpfRegistroFuncional;
    private String emailInstitucional;
    private String telefone;
    private String titulacao;
    private String areaDeAtuacao;
    private String regimeTrabalho;
    
    @ManyToOne
    @JoinColumn(name = "departamento_id")
    private Departamento departamento;
    
    @OneToMany(mappedBy = "professor")
    private List<Aluno> alunos;
    
    @ManyToMany
    @JoinTable(
        name = "professor_funcionario",
        joinColumns = @JoinColumn(name = "professor_id"),
        inverseJoinColumns = @JoinColumn(name = "funcionario_id")
    )
    private List<Funcionario> funcionarios;

    // Construtor do DTO (sem o ID - será gerado pelo JPA)
    public Professor(String nomeCompleto, String cpfRegistroFuncional, String emailInstitucional, String telefone,
            String titulacao, String areaDeAtuacao, String regimeTrabalho) {
        this.nomeCompleto = nomeCompleto;
        this.cpfRegistroFuncional = cpfRegistroFuncional;
        this.emailInstitucional = emailInstitucional;
        this.telefone = telefone;
        this.titulacao = titulacao;
        this.areaDeAtuacao = areaDeAtuacao;
        this.regimeTrabalho = regimeTrabalho;
    }
}