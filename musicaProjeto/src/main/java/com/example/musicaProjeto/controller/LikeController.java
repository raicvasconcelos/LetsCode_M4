package com.example.musicaProjeto.controller;

import com.example.musicaProjeto.dto.CriaPlaylist;
import com.example.musicaProjeto.dto.LikeDTO;
import com.example.musicaProjeto.entity.Musica;
import com.example.musicaProjeto.entity.Pessoa;
import com.example.musicaProjeto.entity.Playlist;
import com.example.musicaProjeto.repository.MusicaRepository;
import com.example.musicaProjeto.repository.PessoaRepository;
import com.example.musicaProjeto.repository.PlaylistRepository;
import net.bytebuddy.implementation.bytecode.Throw;
import org.hibernate.collection.internal.PersistentSortedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/like")
public class LikeController {

    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private MusicaRepository musicaRepository;

@PutMapping
public ResponseEntity adicionaLike(@RequestBody LikeDTO favorito) throws ChangeSetPersister.NotFoundException {

    Optional<Pessoa> pessoaFindID = pessoaRepository.findById(favorito.getPessoaID());
    Optional<Musica> musicaFindID = musicaRepository.findById(favorito.getMusicaID());

    try{
        Musica musicaEncontrada = musicaFindID.orElseThrow(() -> new Exception("Musica não encontrada"));
        Pessoa pessoaEncontrada = pessoaFindID.orElseThrow(() -> new Exception("Pessoa não encontrada"));
        pessoaEncontrada.getLike().add(musicaEncontrada);
        return ResponseEntity.ok().body(pessoaRepository.save(pessoaEncontrada));
    } catch (Exception e) {
        return ResponseEntity.badRequest().body("Error: " + e.getMessage());
    }



}
}
