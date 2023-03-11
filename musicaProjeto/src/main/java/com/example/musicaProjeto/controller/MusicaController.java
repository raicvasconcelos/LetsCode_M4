package com.example.musicaProjeto.controller;

import com.example.musicaProjeto.dto.CriaMusica;
import com.example.musicaProjeto.entity.Musica;
import com.example.musicaProjeto.repository.GeneroRepository;
import com.example.musicaProjeto.repository.MusicaRepository;
import com.example.musicaProjeto.service.MusicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.Repeatable;

@RestController
public class MusicaController {

    MusicaService service;
    @Autowired
    private MusicaRepository musicaRepository;

    @Autowired
    private GeneroRepository generoRepository;

//    @PostMapping("/Musica")
//    public ResponseEntity<Musica> criaMusica(@RequestBody CriaMusica musica){
//        return ResponseEntity.status(HttpStatus.OK).body(musicaRepository.save(musica.getMusica()));
//    }

}
