package org.example.concessionaria.handler;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

public class GlobalExceptionHandier {
@ExceptionHandler(MethodArgumentNotValidException.class)
@ResponseStatus(HttpStatus.BAD_REQUEST)
public Map<String, String> tratarValidacao(MethodArgumentNotValidException ex){
    Map<String, String> erros = new HashMap<>();
    ex.getBindingResult().getFieldErrors().forEach(erro ->
    {
        erros.put(erro.getField(), erro.getDefaultMessage());
    });
    return erros;
}

@ExceptionHandler(RuntimeException.class)
@ResponseStatus(HttpStatus.NOT_FOUND)
public Map<String, String> tratarErro(RuntimeException ex){
    Map<String, String> erro = new HashMap<>();
    erro.put("erro", ex.getMessage());
    return erro;
}

//tratamento de erro para email duplicado
@ExceptionHandler(DataIntegrityViolationException.class)
public ResponseEntity<?> handleErro() {
    return ResponseEntity
            .badRequest()
            .body(Map.of("erro", "E-mail já cadastrado."));
}

        }

