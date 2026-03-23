package com.example.MiniProjeto.repository;

import com.example.MiniProjeto.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FuncionarioRepository extends JpaRepository <Funcionario, Long> {
}
