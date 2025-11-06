package com.example.aula11.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "carteiras_estudante")
@Data
@NoArgsConstructor
public class CarteiraEstudante {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "BINARY(16)")
    private UUID idCarteira;
    
    private String numeroCarteira;
    private LocalDate dataEmissao;
    private LocalDate dataValidade;
    
    @OneToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    public CarteiraEstudante(String numeroCarteira, LocalDate dataEmissao, LocalDate dataValidade) {
        this.numeroCarteira = numeroCarteira;
        this.dataEmissao = dataEmissao;
        this.dataValidade = dataValidade;
    }
}