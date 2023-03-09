package com.example.livrosProjeto.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
//@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Livro {
    @Id
    private int livroId;
    private String titulo;
    private String autor;
    private int ano;
    private Categoria categoria;
    @Column(columnDefinition = "DATE")
    private LocalDate dataEntrega;

    public Livro(int livroId, String titulo, String autor, int ano, Categoria categoria) {
        this.livroId = livroId;
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.categoria = categoria;
        this.dataEntrega = LocalDate.now();
    }
}


