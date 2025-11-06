package com.example.aula11.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "funcionarios")
@Data
@NoArgsConstructor
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "BINARY(16)")
    private UUID idFuncionario;
    private String nomeCompleto;
    private String cpfRegistroFuncional;
    private String emailInstitucional;
    private String telefone;
    private String cargo;
    private String tipoVinculo;
    
    @ManyToOne
    @JoinColumn(name = "departamento_id")
    private Departamento departamento;
    
    @ManyToMany(mappedBy = "funcionarios")
    private List<Professor> professores;
    
    @ManyToMany(mappedBy = "funcionarios")
    private List<Aluno> alunos;

    // Construtor do DTO (sem o ID - será gerado pelo JPA)
    public Funcionario(String nomeCompleto, String cpfRegistroFuncional, String emailInstitucional, String telefone,
            String cargo, String tipoVinculo) {
        this.nomeCompleto = nomeCompleto;
        this.cpfRegistroFuncional = cpfRegistroFuncional;
        this.emailInstitucional = emailInstitucional;
        this.telefone = telefone;
        this.cargo = cargo;
        this.tipoVinculo = tipoVinculo;
    }
}