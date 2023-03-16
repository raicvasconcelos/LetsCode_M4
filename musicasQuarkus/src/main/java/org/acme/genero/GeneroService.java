package org.acme.genero;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class GeneroService {
    @Inject
    GeneroRepository generoRepository;

    public List<Genero> findByName(String name) {
        return generoRepository.findByName(name);
    }

    public List<Genero> findAll() {
        return generoRepository.findAll().list();
    }

    @Transactional
    public void create(Genero genero){
        generoRepository.persistAndFlush(genero);
    }
}
