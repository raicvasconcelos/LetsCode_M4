package com.example.musicaProjeto.repository;

import com.example.musicaProjeto.entity.Musica;
import com.example.musicaProjeto.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
    @Query("SELECT CASE WHEN COUNT(p) > 0 THEN true ELSE false END FROM Pessoa p WHERE p.nome = ?1")
    boolean existsByName(String nome);

    @Query("SELECT CASE WHEN COUNT(p) > 0 THEN true ELSE false END FROM Pessoa p WHERE p.cpf = ?1")
    boolean existsByCPF(String cpf);

//    @Modifying
//    @Transactional
//    @Query("UPDATE Pessoa p SET p.like = CONCAT(p.like, ?2) WHERE p.id = ?1")
//    void addMusicToPerson(Integer pessoaID, Musica musica);
}
