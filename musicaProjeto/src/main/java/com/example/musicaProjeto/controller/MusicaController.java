package com.example.musicaProjeto.controller;

import com.example.musicaProjeto.dto.CriaMusica;
import com.example.musicaProjeto.entity.Genero;
import com.example.musicaProjeto.entity.Musica;
import com.example.musicaProjeto.repository.GeneroRepository;
import com.example.musicaProjeto.repository.MusicaRepository;
import com.example.musicaProjeto.service.MusicaService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class MusicaController {

    MusicaService musicaService = new MusicaService();
    @Autowired
    private MusicaRepository musicaRepository;

    @Autowired
    private GeneroRepository generoRepository;

    @Operation(summary = "Adiciona uma nova música")
    @PostMapping("/musica")
    public ResponseEntity<?> criaMusica(@RequestBody CriaMusica musica){

        Optional<Genero> genero = generoRepository.findBySearchTerm(musica.getGenero().getGeneroNome());

        try{
            Genero generoEncontrado = genero.orElseThrow(() -> new Exception("Gênero não encontrado"));
            generoEncontrado.getMusicas().add(musica.getMusica());
            return ResponseEntity.ok().body(musicaRepository.save(musica.getMusica()));

        }catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
//        Musica musica1 = new Musica();
//
//        musica1.setMusicaNome(musica.getMusica().getMusicaNome());
//        musica1.setArtista(musica.getMusica().getArtista());
//
//        Optional<Genero> genero = generoRepository.findBySearchTerm(musica.getGenero().getGeneroNome());
//        try{
//            Genero generoEncontrado = genero.orElseThrow(() -> new Exception("Gênero não encontrado"));
//            musica1.setGenero(generoEncontrado);
//            generoEncontrado.getMusicas().add(musica1);
//        }catch (Exception e) {
//            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
//        }
//
//
//
//        musicaRepository.save(musica1);
//
//        return ResponseEntity.ok().body(musicaRepository.save(musica1));

    }

    @GetMapping("/musicas")
    public List<Musica> listaMusica(){
        return musicaRepository.findAll();
    }
//
//    @PostMapping("/musica")
//    public ResponseEntity criaMusica(@RequestBody CriaMusica musica){
//        return musicaService.postMusica(musica);
//
//    }

}
