package com.example.livrosProjeto.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
    @GeneratedValue
    private int livroId;
    private String titulo;
    private String autor;
    private int ano;
    private Categoria categoria;

}


