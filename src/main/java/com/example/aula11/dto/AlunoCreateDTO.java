package com.example.aula11.dto;

import java.time.LocalDate;
import lombok.Data;

@Data
public class AlunoCreateDTO {
    private String nomeCompleto;
    private LocalDate dataNascimento;
    private String cpfMatriculaNacional;
    private String matricula;
    private String emailInstitucional;
    private String telefone;
}