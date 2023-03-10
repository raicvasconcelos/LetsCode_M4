package com.example.musicaProjeto.repository;

import com.example.musicaProjeto.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
}
