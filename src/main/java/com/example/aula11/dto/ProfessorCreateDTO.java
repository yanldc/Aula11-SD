package com.example.aula11.dto;

import lombok.Data;

@Data
public class ProfessorCreateDTO {
    private String nomeCompleto;
    private String cpfRegistroFuncional;
    private String emailInstitucional;
    private String telefone;
    private String titulacao;
    private String areaDeAtuacao;
    private String regimeTrabalho;
}