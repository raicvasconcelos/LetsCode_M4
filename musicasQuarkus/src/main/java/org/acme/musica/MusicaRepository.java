package org.acme.musica;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MusicaRepository implements PanacheRepository<Musica> {

    public Musica findByName(String musicaNome){
        return find("musicaNome = ?1", musicaNome).firstResult();
    }
}
