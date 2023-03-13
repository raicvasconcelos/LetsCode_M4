package com.example.musicaProjeto.controller;

import com.example.musicaProjeto.dto.CriaGenero;
import com.example.musicaProjeto.entity.Genero;
import com.example.musicaProjeto.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/genero")
public class GeneroController {

    @Autowired
    private GeneroRepository generoRepository;

    @PostMapping
    public ResponseEntity cadastroGenero(@RequestBody CriaGenero genero){
        if(!generoRepository.existsByName(genero.getGenero().getGeneroNome())){
            return ResponseEntity.status(HttpStatus.OK).body(generoRepository.save(genero.getGenero()));
        }else {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, String.format("Gênero não cadastrado"));
        }
    }

    @GetMapping
    public List<Genero> listaGenero(){
        return generoRepository.findAll();
    }

    @GetMapping({"/{generoNome}"})
    public ResponseEntity getGeneroByName(@PathVariable String generoNome){

        Optional<Genero> generoFind = generoRepository.findBySearchTerm(generoNome);

        try{
            Genero generoEncontrado = generoFind.orElseThrow(() -> new Exception("Gênero não encontrado"));
            return ResponseEntity.ok().body(generoEncontrado.getMusicas());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }


    }


}
