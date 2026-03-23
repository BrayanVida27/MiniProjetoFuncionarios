package com.example.MiniProjeto.controller;

import com.example.MiniProjeto.model.Funcionario;
import com.example.MiniProjeto.service.FuncionarioService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    private final FuncionarioService service;

    public FuncionarioController(FuncionarioService service){
        this.service = service;
    }

    @GetMapping
    public List<Funcionario> listar(){
        return service.listar();
    }

    @PostMapping
    public Funcionario criar(@RequestBody @Valid Funcionario funcionario){
        return service.salvar(funcionario);


    }
    @GetMapping("/{id}")
    public Funcionario buscar(@PathVariable Long id){
        return service.buscar(id);
    }

    @PutMapping("/{id}")
    public Funcionario atualizar(@PathVariable Long id, @RequestBody @Valid Funcionario funcionario){
        funcionario.setId(id);
        return service.salvar(funcionario);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id){
        service.remover(id);
    }

}
