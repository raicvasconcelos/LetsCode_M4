package org.acme.pessoa;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import org.acme.musica.Musica;
import org.acme.playlist.Playlist;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
@Entity
@Table(name="pessoa")
public class Pessoa extends PanacheEntity {

    private String nome;
    private String cpf;

    @OneToMany
    private List<Musica> like ;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Playlist> playlists;

}
