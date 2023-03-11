package com.example.musicaProjeto.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Genero {
    @Id
    @GeneratedValue
    private int id;
    private String generoNome;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Musica> musicas;

}
