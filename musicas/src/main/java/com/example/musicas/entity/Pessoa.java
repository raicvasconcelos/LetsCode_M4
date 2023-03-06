package com.example.musicas.entity;

import lombok.Getter;
import lombok.Setter;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;
@Entity
@Setter
@Getter
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id;
    private UUID uuid;
    private String nome;
    @OneToMany
    private List<Playlist> playlists;
    @ManyToMany
    private Musica curtida;

}
