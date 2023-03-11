package com.example.musicaProjeto.controller;

import com.example.musicaProjeto.dto.CriaMusica;
import com.example.musicaProjeto.entity.Genero;
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

    @PostMapping("/musica")
    public ResponseEntity<?> criaMusica(@RequestBody CriaMusica musica){
        boolean generoExits = generoRepository.existsByName(musica.getGenero().getGeneroNome());

        if(!generoExits){
            return ResponseEntity.badRequest().body("Genero not found");
        }
        Musica musica1 = new Musica();

        Genero genero = generoRepository.findBySearchTerm(musica.getGenero().getGeneroNome());
//
        musica1.setMusicaNome(musica.getMusica().getMusicaNome());
        musica1.setArtista(musica.getMusica().getArtista());
        musica1.setGenero(genero);

        musicaRepository.save(musica1);

        return ResponseEntity.ok(musica1);

//        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
    }

}
