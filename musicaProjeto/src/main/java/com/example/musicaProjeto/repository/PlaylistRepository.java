package com.example.musicaProjeto.repository;

import com.example.musicaProjeto.entity.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PlaylistRepository extends JpaRepository<Playlist, Integer> {

    @Query("SELECT pl FROM Playlist pl WHERE pl.playlistNome LIKE %:searchTerm%")
    Optional<Playlist> findByName(@Param("searchTerm") String playlistNome);
}
