package com.example.musicaProjeto.repository;

import com.example.musicaProjeto.entity.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaylistRepository extends JpaRepository<Playlist, Integer> {
}
