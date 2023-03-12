package com.example.musicaProjeto.repository;

import com.example.musicaProjeto.entity.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MusicaRepository extends JpaRepository<Musica, Integer> {
    @Query("SELECT CASE WHEN COUNT(m) > 0 THEN true ELSE false END FROM Musica m WHERE m.musicaNome = ?1")
    boolean existsByName(String musicaNome);
}
