package com.example.MiniProjeto.service;

import com.example.MiniProjeto.model.Funcionario;
import com.example.MiniProjeto.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {
    private final FuncionarioRepository repository;
    public FuncionarioService(FuncionarioRepository repository){
        this.repository = repository;
    }
    public Funcionario salvar(Funcionario funcionario){
        return repository.save(funcionario);
    }

    public Funcionario buscar(Long id){
        return repository.findById(id).orElseThrow(()
                -> new RuntimeException("Funcionario não foi encontrado!"));
    }

    public List<Funcionario> listar(){
        return repository.findAll();
    }


    public void remover(Long id){
        repository.deleteById(id);
    }

}

