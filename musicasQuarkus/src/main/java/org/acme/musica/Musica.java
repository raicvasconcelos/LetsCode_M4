package org.acme.musica;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import org.acme.genero.Genero;
import org.acme.pessoa.Pessoa;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="musica")
public class Musica extends PanacheEntity {

    private String musicaNome;
    private String artista;

    @ManyToOne
    private Genero genero;

    @ManyToOne
    private Pessoa like;
}
