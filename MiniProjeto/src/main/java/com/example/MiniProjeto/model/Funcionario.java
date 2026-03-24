package com.example.MiniProjeto.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;


import javax.xml.crypto.Data;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "TBFUNCIONARIOS")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // id do Funcionario
    private Long id;
    // o Email do funcinario

    @Column(unique = true, nullable = false, length = 100)
    @Email(message = "O e-mail deve ser válido.")
    @NotBlank(message = "O e-mail não pode ser nulo!")
    private String email;

    @NotBlank(message = "Preencha o nome do funcionario!")
    // nome do Funcionario
    private String nome;

    @NotBlank(message = "Preencha o Cargo do funcionario!")
    // o cargo do funcionario
    private String cargo;

    @NotNull(message = "Preencha o Salario do Funcionario")
    @Positive(message = "O salario deve ser positivo")
    private Double salario;

    public Funcionario(){}
}
