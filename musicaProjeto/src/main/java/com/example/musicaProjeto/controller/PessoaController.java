package com.example.musicaProjeto.controller;

import com.example.musicaProjeto.dto.PessoaDTO;
import com.example.musicaProjeto.entity.Pessoa;
import com.example.musicaProjeto.repository.PessoaRepository;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@AllArgsConstructor
@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;
    @Operation(summary = "Adiciona uma nova pessoa")
    @PostMapping
    public Pessoa criaPessoa(@RequestBody PessoaDTO pessoa){

        return pessoaRepository.save(pessoa.getPessoa());
    }
    @Operation(summary = "Lista todos as pessoas.")
    @GetMapping
    public List<Pessoa> listaMusica(){
        return pessoaRepository.findAll();
    }
    @Operation(summary = "Encontra pessoa pelo ID")
    @GetMapping({"/{pessoaID}"})
    public ResponseEntity getPessoaByID(@PathVariable Integer pessoaID){
        Optional<Pessoa> pessoaFindID = pessoaRepository.findById(pessoaID);

        try{
            Pessoa pessoaEncontrada = pessoaFindID.orElseThrow(() -> new Exception("Pessoa não encontrada"));
            return ResponseEntity.ok().body(pessoaEncontrada);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }
}
