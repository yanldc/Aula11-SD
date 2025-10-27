package com.example.aula11.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

@Data
@NoArgsConstructor
public class Professor {
    private UUID idProfessor;
    private String nomeCompleto;
    private String cpfRegistroFuncional;
    private String emailInstitucional;
    private String telefone;
    private String titulacao;
    private String areaDeAtuacao;
    private String regimeTrabalho;

    // Construtor do DTO
    public Professor(String nomeCompleto, String cpfRegistroFuncional, String emailInstitucional, String telefone,
            String titulacao, String areaDeAtuacao, String regimeTrabalho) {
        this.idProfessor = UUID.randomUUID();
        this.nomeCompleto = nomeCompleto;
        this.cpfRegistroFuncional = cpfRegistroFuncional;
        this.emailInstitucional = emailInstitucional;
        this.telefone = telefone;
        this.titulacao = titulacao;
        this.areaDeAtuacao = areaDeAtuacao;
        this.regimeTrabalho = regimeTrabalho;
    }
}