package com.example.musicaProjeto.config;

import com.example.musicaProjeto.entity.Genero;
import com.example.musicaProjeto.entity.Musica;
import com.example.musicaProjeto.repository.GeneroRepository;
import com.example.musicaProjeto.repository.MusicaRepository;
import com.example.musicaProjeto.repository.PessoaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
@AllArgsConstructor
public class DBConfig2 {

    private PessoaRepository pessoaRepository;
    @Autowired
    private MusicaRepository musicaRepository;
    @Autowired
    private GeneroRepository generoRepository;

    @PostConstruct
    public void initDB(){

        Musica musica1 = new Musica();
        musica1.setMusicaNome("Silver Soul");
        musica1.setArtista("Beach House");
        Genero dreamPop = generoRepository.findGenero("Dream Pop");
        musica1.setGenero(dreamPop );
        musicaRepository.saveAndFlush(musica1);
        musicaRepository.flush();

    }
}
