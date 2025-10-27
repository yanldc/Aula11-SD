package com.example.aula11.dto;

import java.util.UUID;
import lombok.Data;

@Data
public class DepartamentoCreateDTO {
    private String nome;
    private String sigla;
    private String centroUnidadeAcademica;
    private UUID chefeDepartamentoId;
    private String tipoChefe;
    private String emailContato;
    private String telefoneRamal;
    private String localizacao;
}