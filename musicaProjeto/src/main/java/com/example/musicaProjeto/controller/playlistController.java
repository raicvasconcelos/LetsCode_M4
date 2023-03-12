package com.example.musicaProjeto.controller;

import com.example.musicaProjeto.dto.CriaMusica;
import com.example.musicaProjeto.dto.CriaPessoa;
import com.example.musicaProjeto.dto.CriaPlaylist;
import com.example.musicaProjeto.entity.Genero;
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
public class playlistController {
    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private PlaylistRepository playlistRepository;

    @Autowired
    private MusicaRepository musicaRepository;

    @PostMapping("/playlist")
    public ResponseEntity<?> criaPlaylist(@RequestBody CriaPlaylist playlist){
        boolean pessoaExists = pessoaRepository.existsByName(playlist.getPessoa().getNome());
        if(!pessoaExists){
            return ResponseEntity.badRequest().body("Pessoa não encontrado");
        }
        Playlist playlist1 = new Playlist();

        playlist1.setPlaylistNome(playlist.getPlaylistNome());
        playlist1.setPessoa(playlist.getPessoa());

        List<Musica> musica = new ArrayList<>();
        playlist1.setMusica((musica));


        playlistRepository.save(playlist1);

        return ResponseEntity.ok().body("Playlist "  + playlist1.getPlaylistNome() + " criada");




    }
}
