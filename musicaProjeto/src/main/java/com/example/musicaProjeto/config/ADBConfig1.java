package com.example.musicaProjeto.config;

import com.example.musicaProjeto.entity.Genero;
import com.example.musicaProjeto.entity.Pessoa;
import com.example.musicaProjeto.repository.GeneroRepository;
import com.example.musicaProjeto.repository.MusicaRepository;
import com.example.musicaProjeto.repository.PessoaRepository;
import com.example.musicaProjeto.service.MusicaService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
@AllArgsConstructor
public class ADBConfig1 {

    private PessoaRepository pessoaRepository;

    private GeneroRepository generoRepository;

    private MusicaService musicaService;


    @PostConstruct
    public void initDB(){
        Pessoa pessoa1 = new Pessoa();
        pessoa1.setNome("Anthony Fantano");
        pessoa1.setCpf("552.986.098-07");
        pessoaRepository.saveAndFlush(pessoa1);
        Pessoa pessoa2 = new Pessoa();
        pessoa2.setNome("Frank");
        pessoa2.setCpf("822.966.112-97");
        pessoaRepository.saveAndFlush(pessoa2);


        Genero genero1 = new Genero();
        genero1.setGeneroNome("Dream Pop");
        generoRepository.saveAndFlush(genero1);
        Genero genero2 = new Genero();
        genero2.setGeneroNome("Post-Punk Sovietico");
        generoRepository.saveAndFlush(genero2);
        Genero genero3 = new Genero();
        genero3.setGeneroNome("Metal Progressivo");
        generoRepository.saveAndFlush(genero3);


    }


}
