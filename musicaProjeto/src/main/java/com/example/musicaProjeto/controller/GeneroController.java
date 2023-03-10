package com.example.musicaProjeto.controller;

import com.example.musicaProjeto.dto.CriaGenero;
import com.example.musicaProjeto.entity.Genero;
import com.example.musicaProjeto.repository.GeneroRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/genero")
@AllArgsConstructor
public class GeneroController {

    @Autowired
    private GeneroRepository generoRepository;
    @Operation(summary = "Adiciona um novo gênero.")
    @PostMapping
    public ResponseEntity cadastroGenero(@RequestBody CriaGenero genero){
        if(!generoRepository.existsByName(genero.getGenero().getGeneroNome())){
            return ResponseEntity.status(HttpStatus.OK).body(generoRepository.save(genero.getGenero()));
        }else {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, String.format("Gênero não cadastrado"));
        }
    }
    @Operation(summary = "Lista todos os gêneros.")
    @GetMapping
    public List<Genero> listaGenero(){
        return generoRepository.findAll();
    }

    @Operation(summary = "Lista todas das musicas do mesmo gênero.")
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
