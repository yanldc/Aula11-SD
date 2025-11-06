package com.example.aula11.service;

import com.example.aula11.dto.CarteiraEstudanteCreateDTO;
import com.example.aula11.model.CarteiraEstudante;
import com.example.aula11.model.Aluno;
import com.example.aula11.repository.CarteiraEstudanteRepository;
import com.example.aula11.repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CarteiraEstudanteService {

    private final CarteiraEstudanteRepository carteiraRepository;
    private final AlunoRepository alunoRepository;

    public CarteiraEstudanteService(CarteiraEstudanteRepository carteiraRepository, AlunoRepository alunoRepository) {
        this.carteiraRepository = carteiraRepository;
        this.alunoRepository = alunoRepository;
    }

    public List<CarteiraEstudante> getAllCarteiras() {
        return carteiraRepository.findAll();
    }

    public CarteiraEstudante getCarteiraById(UUID id) {
        return carteiraRepository.findById(id).orElse(null);
    }

    public CarteiraEstudante createCarteira(CarteiraEstudanteCreateDTO dto) {
        CarteiraEstudante carteira = new CarteiraEstudante(
                dto.getNumeroCarteira(),
                dto.getDataEmissao(),
                dto.getDataValidade());
        
        if (dto.getAlunoId() != null) {
            Aluno aluno = alunoRepository.findById(dto.getAlunoId()).orElse(null);
            carteira.setAluno(aluno);
        }
        
        return carteiraRepository.save(carteira);
    }

    public CarteiraEstudante updateCarteira(UUID id, CarteiraEstudanteCreateDTO dto) {
        CarteiraEstudante carteira = carteiraRepository.findById(id).orElse(null);
        if (carteira != null) {
            carteira.setNumeroCarteira(dto.getNumeroCarteira());
            carteira.setDataEmissao(dto.getDataEmissao());
            carteira.setDataValidade(dto.getDataValidade());
            
            if (dto.getAlunoId() != null) {
                Aluno aluno = alunoRepository.findById(dto.getAlunoId()).orElse(null);
                carteira.setAluno(aluno);
            }
            
            return carteiraRepository.save(carteira);
        }
        return null;
    }

    public boolean deleteCarteira(UUID id) {
        if (carteiraRepository.existsById(id)) {
            carteiraRepository.deleteById(id);
            return true;
        }
        return false;
    }
}