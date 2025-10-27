package com.example.aula11.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

@Data
@NoArgsConstructor
public class Departamento {
    private UUID idDepartamento;
    private String nome;
    private String sigla;
    private String centroUnidadeAcademica;
    private UUID chefeDepartamentoId;
    private String tipoChefe;
    private String emailContato;
    private String telefoneRamal;
    private String localizacao;

    // Construtor do DTO
    public Departamento(String nome, String sigla, String centroUnidadeAcademica, UUID chefeDepartamentoId,
            String tipoChefe, String emailContato, String telefoneRamal, String localizacao) {
        this.idDepartamento = UUID.randomUUID();
        this.nome = nome;
        this.sigla = sigla;
        this.centroUnidadeAcademica = centroUnidadeAcademica;
        this.chefeDepartamentoId = chefeDepartamentoId;
        this.tipoChefe = tipoChefe;
        this.emailContato = emailContato;
        this.telefoneRamal = telefoneRamal;
        this.localizacao = localizacao;
    }
}