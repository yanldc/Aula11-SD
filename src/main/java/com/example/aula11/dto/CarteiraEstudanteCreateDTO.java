package com.example.aula11.dto;

import lombok.Data;
import java.time.LocalDate;
import java.util.UUID;

@Data
public class CarteiraEstudanteCreateDTO {
    private String numeroCarteira;
    private LocalDate dataEmissao;
    private LocalDate dataValidade;
    private UUID alunoId;
}