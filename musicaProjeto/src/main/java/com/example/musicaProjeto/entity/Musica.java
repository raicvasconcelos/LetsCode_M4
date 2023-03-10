package com.example.musicaProjeto.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Musica {
    @Id
    @GeneratedValue
    private int id;
    private String musicaNome;
    private String artista;
    @ManyToOne
    private Genero genero;




}
