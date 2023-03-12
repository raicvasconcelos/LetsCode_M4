package com.example.musicaProjeto.service;

import com.example.musicaProjeto.entity.Genero;
import com.example.musicaProjeto.entity.Musica;
import com.example.musicaProjeto.repository.GeneroRepository;
import com.example.musicaProjeto.repository.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MusicaService {
    @Autowired
    private MusicaRepository musicaRepository;

    @Autowired
    private GeneroRepository generoRepository;

    public ResponseEntity<?> postMusica(CriaMusica musica){
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

    }

}
