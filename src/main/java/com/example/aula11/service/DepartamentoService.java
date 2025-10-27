package com.example.aula11.service;

import com.example.aula11.dto.DepartamentoCreateDTO;
import com.example.aula11.model.Departamento;
import com.example.aula11.repository.DepartamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DepartamentoService {

    private final DepartamentoRepository departamentoRepository;

    public DepartamentoService(DepartamentoRepository departamentoRepository) {
        this.departamentoRepository = departamentoRepository;
    }

    public List<Departamento> getAllDepartamentos() {
        return departamentoRepository.findAll();
    }

    public Departamento getDepartamentoById(UUID id) {
        return departamentoRepository.findById(id).orElse(null);
    }

    public Departamento createDepartamento(DepartamentoCreateDTO dto) {
        Departamento departamento = new Departamento(
                dto.getNome(),
                dto.getSigla(),
                dto.getCentroUnidadeAcademica(),
                dto.getChefeDepartamentoId(),
                dto.getTipoChefe(),
                dto.getEmailContato(),
                dto.getTelefoneRamal(),
                dto.getLocalizacao());
        return departamentoRepository.save(departamento);
    }

    public Departamento updateDepartamento(UUID id, DepartamentoCreateDTO dto) {
        Departamento departamento = departamentoRepository.findById(id).orElse(null);
        if (departamento != null) {
            departamento.setNome(dto.getNome());
            departamento.setSigla(dto.getSigla());
            departamento.setCentroUnidadeAcademica(dto.getCentroUnidadeAcademica());
            departamento.setChefeDepartamentoId(dto.getChefeDepartamentoId());
            departamento.setTipoChefe(dto.getTipoChefe());
            departamento.setEmailContato(dto.getEmailContato());
            departamento.setTelefoneRamal(dto.getTelefoneRamal());
            departamento.setLocalizacao(dto.getLocalizacao());
            return departamentoRepository.save(departamento);
        }
        return null;
    }

    public boolean deleteDepartamento(UUID id) {
        if (departamentoRepository.findById(id).isPresent()) {
            departamentoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}