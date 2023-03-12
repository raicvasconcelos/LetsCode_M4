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
public class Pessoa {
    @Id
    @GeneratedValue
    private int id;
    private String nome;
    private String cpf;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Musica> like;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Playlist> playlists;

}
