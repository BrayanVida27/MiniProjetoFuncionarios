package org.example.concessionaria.repository;

import org.example.concessionaria.model.Carro;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@SpringBootApplication
public interface CarroRepository extends
        JpaRepository <Carro, Long> {

    }
