package org.example.concessionaria.service;

import org.example.concessionaria.model.Carro;
import org.example.concessionaria.repository.CarroRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroService {

    private final CarroRepository repository;

    public CarroService(CarroRepository repository){
        this.repository = repository;
    }

    public List<Carro> listar(){
        return repository.findAll();
    }

    public Carro salvar(Carro carro){
         return repository.save(carro);
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }

    public void remover(Long id){
        repository.deleteById(id);
    }

}
