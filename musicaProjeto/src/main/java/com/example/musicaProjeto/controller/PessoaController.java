package com.example.musicaProjeto.controller;

import com.example.musicaProjeto.dto.CriaPessoa;
import com.example.musicaProjeto.entity.Pessoa;
import com.example.musicaProjeto.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @PostMapping("/pessoa")
    public Pessoa criaPessoa(@RequestBody CriaPessoa pessoa){


        return pessoaRepository.save(pessoa.getPessoa());
    }
}
