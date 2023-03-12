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
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String playlistNome;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Pessoa pessoa;
    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Musica> musicas;





}
