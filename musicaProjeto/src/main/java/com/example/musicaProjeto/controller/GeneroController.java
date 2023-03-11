package com.example.musicaProjeto.controller;

import com.example.musicaProjeto.dto.CriaGenero;
import com.example.musicaProjeto.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class GeneroController {

    @Autowired
    private GeneroRepository generoRepository;

    @PostMapping("/genero")
    public ResponseEntity cadastroGenero(@RequestBody CriaGenero genero){
        if(!generoRepository.existsByName(genero.getGenero().getGeneroNome())){
            return ResponseEntity.status(HttpStatus.OK).body(generoRepository.save(genero.getGenero()));
        }else {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, String.format("Gênero não cadastrado"));
        }
    }

}
