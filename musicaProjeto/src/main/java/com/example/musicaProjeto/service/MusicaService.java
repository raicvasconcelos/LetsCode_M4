package com.example.musicaProjeto.service;

import com.example.musicaProjeto.controller.MusicaController;
import com.example.musicaProjeto.dto.CriaMusica;
import com.example.musicaProjeto.entity.Genero;
import com.example.musicaProjeto.entity.Musica;
import com.example.musicaProjeto.repository.GeneroRepository;
import com.example.musicaProjeto.repository.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class MusicaService {

    MusicaRepository musicaRepository;

    @Autowired
    private GeneroRepository generoRepository;

    public Musica postMusica(CriaMusica musica){
        Genero genero = new Genero();

        boolean exists = generoRepository.existsByName(musica.getGenero().getGeneroNome());
        if(exists){
            return musica.getMusica();
        }else{
            System.out.println("Gênero não cadastrado");
        }return null;
    }
}
