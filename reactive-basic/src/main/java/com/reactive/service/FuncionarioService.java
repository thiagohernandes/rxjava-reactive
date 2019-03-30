package com.reactive.service;

import com.reactive.model.Funcionario;
import com.reactive.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    FuncionarioRepository funcionarioRepository;

    public List<Funcionario> getAll() {
        return funcionarioRepository.findAll();
    }

    public Optional<Funcionario> getById(Integer id) {
        return funcionarioRepository.findById(id);
    }

    public void deleteById(Integer id) {
        funcionarioRepository.deleteById(id);
    }

    public Funcionario create(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }
}
