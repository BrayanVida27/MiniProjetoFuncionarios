package org.example.concessionaria.controller;

import jakarta.validation.Valid;
import org.example.concessionaria.model.Carro;
import org.example.concessionaria.service.CarroService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/concessionaria")
public class CarroController {


    private final CarroService service;

    public CarroController(CarroService service){
        this.service = service;
    }

    @GetMapping
    public List<Carro> listar(){
        return service.listar();
    }

    @PostMapping
    public Carro criar(@RequestBody @Valid Carro carro){
        return service.salvar(carro);
    }

    @PutMapping("/{id}")
    public Carro atualizar(@PathVariable Long id,
     @RequestBody @Valid Carro carro){
        carro.setId(id);
        return service.salvar(carro);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id){
        service.remover(id);
    }

}


