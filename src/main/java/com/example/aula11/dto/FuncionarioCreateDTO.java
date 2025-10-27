package com.example.aula11.dto;

import lombok.Data;

@Data
public class FuncionarioCreateDTO {
    private String nomeCompleto;
    private String cpfRegistroFuncional;
    private String emailInstitucional;
    private String telefone;
    private String cargo;
    private String tipoVinculo;
}