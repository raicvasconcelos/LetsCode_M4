package com.example.musicaProjeto.controller;

import com.example.musicaProjeto.dto.CriaPlaylist;
import com.example.musicaProjeto.entity.Musica;
import com.example.musicaProjeto.entity.Pessoa;
import com.example.musicaProjeto.entity.Playlist;
import com.example.musicaProjeto.repository.MusicaRepository;
import com.example.musicaProjeto.repository.PessoaRepository;
import com.example.musicaProjeto.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/playlist")
public class playlistController {
    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private PlaylistRepository playlistRepository;

    @Autowired
    private MusicaRepository musicaRepository;

    @PostMapping
    public ResponseEntity<?> criaPlaylist(@RequestBody CriaPlaylist playlist){

        Optional<Pessoa> pessoaFindID = pessoaRepository.findById(playlist.getPessoaID());
        Optional<Musica> musicaFindID = musicaRepository.findById(playlist.getMusicaID());

        try{
            Musica musicaEncontrada = musicaFindID.orElseThrow(() -> new Exception("Musica não encontrada"));
            Pessoa pessoaEncontrada = pessoaFindID.orElseThrow(() -> new Exception("Pessoa não encontrada"));

            Playlist playlist1 = new Playlist();
            playlist1.setMusicas(new ArrayList<>());

            playlist1.setPlaylistNome(playlist.getPlaylistNome());
            playlist1.setPessoa(pessoaEncontrada);
            playlist1.getMusicas().add(musicaEncontrada);

            return ResponseEntity.ok().body(playlistRepository.save(playlist1));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }

//


    }
    @PutMapping
    public ResponseEntity adicionaMusicaPlaylist(@RequestBody CriaPlaylist addMusica){
        Optional<Pessoa> pessoaFindID = pessoaRepository.findById(addMusica.getPessoaID());
        Optional<Musica> musicaFindID = musicaRepository.findById(addMusica.getMusicaID());
        Optional<Playlist> playlistFind = playlistRepository.findByName(addMusica.getPlaylistNome());

        try{
            Musica musicaEncontrada = musicaFindID.orElseThrow(() -> new Exception("Musica não encontrada"));
            Pessoa pessoaEncontrada = pessoaFindID.orElseThrow(() -> new Exception("Pessoa não encontrada"));
            Playlist playlistEncontrada = playlistFind.orElseThrow(() -> new Exception("Playlist não encontrada"));
            playlistEncontrada.getMusicas().add(musicaEncontrada);
            return ResponseEntity.ok().body(playlistRepository.save(playlistEncontrada));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }

    }
    }

