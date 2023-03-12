package com.example.musicaProjeto.controller;

import com.example.musicaProjeto.dto.CriaMusica;
import com.example.musicaProjeto.entity.Genero;
import com.example.musicaProjeto.entity.Musica;
import com.example.musicaProjeto.repository.GeneroRepository;
import com.example.musicaProjeto.repository.MusicaRepository;
import com.example.musicaProjeto.service.MusicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MusicaController {

    MusicaService musicaService = new MusicaService();
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
            return ResponseEntity.badRequest().body("Gênero não encontrado");
        }
        Musica musica1 = new Musica();

        musica1.setMusicaNome(musica.getMusica().getMusicaNome());
        musica1.setArtista(musica.getMusica().getArtista());

        Genero genero = generoRepository.findBySearchTerm(musica.getGenero().getGeneroNome());
        musica1.setGenero(genero);

        musicaRepository.save(musica1);

        return ResponseEntity.ok().body("Musica " + musica1.getMusicaNome()  + " salva no banco de dados");

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
