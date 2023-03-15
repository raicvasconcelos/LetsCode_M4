package com.example.musicaProjeto.service;

import com.example.musicaProjeto.entity.Genero;
import com.example.musicaProjeto.entity.Musica;
import com.example.musicaProjeto.repository.GeneroRepository;
import com.example.musicaProjeto.repository.MusicaRepository;
import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MusicaService {
    @Autowired
    private MusicaRepository musicaRepository;

    @Autowired
    private GeneroRepository generoRepository;

public void create(Musica musica){
    Genero genero = generoRepository.findBySearchTerm(musica.getGenero().getGeneroNome()).orElse(null);

    Musica musicaNova = new Musica();
    musicaNova.setMusicaNome(musica.getMusicaNome());
    musicaNova.setArtista(musica.getArtista());
    musicaNova.setGenero(genero);

    musicaRepository.save(musicaNova);
}
}
