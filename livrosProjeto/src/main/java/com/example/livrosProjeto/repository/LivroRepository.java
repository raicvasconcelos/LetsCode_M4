package com.example.livrosProjeto.repository;

import com.example.livrosProjeto.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Integer> {
}
