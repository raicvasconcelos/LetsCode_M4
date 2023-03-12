package com.example.musicaProjeto.controller;

import com.example.musicaProjeto.dto.CriaPlaylist;
import com.example.musicaProjeto.entity.Musica;
import com.example.musicaProjeto.entity.Playlist;
import com.example.musicaProjeto.repository.MusicaRepository;
import com.example.musicaProjeto.repository.PessoaRepository;
import com.example.musicaProjeto.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@RestController
public class LikeController {

    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private PlaylistRepository playlistRepository;

    @Autowired
    private MusicaRepository musicaRepository;

    @PostMapping("/like")
    public ResponseEntity<?> criaFavoritos(@RequestBody CriaPlaylist playlistFavoritos){
        boolean pessoaExists = pessoaRepository.existsByName(playlistFavoritos.getPessoa().getNome());
        if(!pessoaExists){
            return ResponseEntity.badRequest().body("Pessoa não encontrado");
        }
        Playlist favoritos = new Playlist();

        favoritos.setPlaylistNome("Favoritos");
        favoritos.setPessoa(playlistFavoritos.getPessoa());

        List<Musica> musica = new ArrayList<>();
        favoritos.setMusicas((musica));


        playlistRepository.save(favoritos);

        return ResponseEntity.ok().body("Playlist Favoritos criada");




    }
}
