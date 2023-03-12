package com.example.musicaProjeto.controller;

import com.example.musicaProjeto.dto.CriaPessoa;
import com.example.musicaProjeto.entity.Musica;
import com.example.musicaProjeto.entity.Pessoa;
import com.example.musicaProjeto.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @PostMapping
    public Pessoa criaPessoa(@RequestBody CriaPessoa pessoa){

        return pessoaRepository.save(pessoa.getPessoa());
    }

    @GetMapping
    public List<Pessoa> listaMusica(){
        return pessoaRepository.findAll();
    }

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
