package com.example.aula11.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

@Data
@NoArgsConstructor
public class Funcionario {
    private UUID idFuncionario;
    private String nomeCompleto;
    private String cpfRegistroFuncional;
    private String emailInstitucional;
    private String telefone;
    private String cargo;
    private String tipoVinculo;

    // Construtor do DTO
    public Funcionario(String nomeCompleto, String cpfRegistroFuncional, String emailInstitucional, String telefone,
            String cargo, String tipoVinculo) {
        this.idFuncionario = UUID.randomUUID();
        this.nomeCompleto = nomeCompleto;
        this.cpfRegistroFuncional = cpfRegistroFuncional;
        this.emailInstitucional = emailInstitucional;
        this.telefone = telefone;
        this.cargo = cargo;
        this.tipoVinculo = tipoVinculo;
    }
}