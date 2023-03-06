package com.example.musicas.entity;

import com.example.musicas.type.GeneroMusical;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Musica {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
  private UUID uid;
  private String titulo;
  private String artista;
  private Enum<GeneroMusical> generoMusical;
  private Pessoa curtida;
}
