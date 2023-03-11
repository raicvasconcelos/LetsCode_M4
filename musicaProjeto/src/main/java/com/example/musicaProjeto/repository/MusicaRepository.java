package com.example.musicaProjeto.repository;

import com.example.musicaProjeto.entity.Musica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicaRepository extends JpaRepository<Musica, Integer> {
}
