package com.example.aula11.service;

import com.example.aula11.dto.FuncionarioCreateDTO;
import com.example.aula11.model.Funcionario;
import com.example.aula11.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public List<Funcionario> getAllFuncionarios() {
        return funcionarioRepository.findAll();
    }

    public Funcionario getFuncionarioById(UUID id) {
        return funcionarioRepository.findById(id).orElse(null);
    }

    public Funcionario createFuncionario(FuncionarioCreateDTO dto) {
        Funcionario funcionario = new Funcionario(
                dto.getNomeCompleto(),
                dto.getCpfRegistroFuncional(),
                dto.getEmailInstitucional(),
                dto.getTelefone(),
                dto.getCargo(),
                dto.getTipoVinculo());
        return funcionarioRepository.save(funcionario);
    }

    public Funcionario updateFuncionario(UUID id, FuncionarioCreateDTO dto) {
        Funcionario funcionario = funcionarioRepository.findById(id).orElse(null);
        if (funcionario != null) {
            funcionario.setNomeCompleto(dto.getNomeCompleto());
            funcionario.setCpfRegistroFuncional(dto.getCpfRegistroFuncional());
            funcionario.setEmailInstitucional(dto.getEmailInstitucional());
            funcionario.setTelefone(dto.getTelefone());
            funcionario.setCargo(dto.getCargo());
            funcionario.setTipoVinculo(dto.getTipoVinculo());
            return funcionarioRepository.save(funcionario);
        }
        return null;
    }

    public boolean deleteFuncionario(UUID id) {
        if (funcionarioRepository.findById(id).isPresent()) {
            funcionarioRepository.deleteById(id);
            return true;
        }
        return false;
    }
}