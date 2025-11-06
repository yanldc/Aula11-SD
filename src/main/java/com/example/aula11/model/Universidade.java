package com.example.aula11.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "universidades")
@Data
@NoArgsConstructor
public class Universidade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "BINARY(16)")
    private UUID idUniversidade;
    
    private String nomeUniversidade;
    private String siglaUniversidade;
    private String tipo; // pública ou privada
    
    @OneToMany(mappedBy = "universidade")
    private List<Departamento> departamentos;

    public Universidade(String nomeUniversidade, String siglaUniversidade, String tipo) {
        this.nomeUniversidade = nomeUniversidade;
        this.siglaUniversidade = siglaUniversidade;
        this.tipo = tipo;
    }
}