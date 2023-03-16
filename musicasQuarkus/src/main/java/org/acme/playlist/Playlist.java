package org.acme.playlist;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import org.acme.musica.Musica;
import org.acme.pessoa.Pessoa;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name="playlist")
public class Playlist extends PanacheEntity {

    private String playlistNome;
    @ManyToOne
    private Pessoa pessoa;
    @ManyToMany
    private List<Musica> musicas;

}
