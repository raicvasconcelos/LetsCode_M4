package org.acme.genero;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Data;
import org.acme.musica.Musica;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="genero")
@Data
public class Genero  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public String generoNome;

    @OneToMany
    public List<Musica> musicas;
}
