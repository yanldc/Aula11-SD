package com.example.aula11.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
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