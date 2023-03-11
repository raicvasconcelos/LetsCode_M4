package com.example.musicaProjeto.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

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
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Genero genero;
//    @JoinColumn(name = "genero_id", referencedColumnName = "id")





}
