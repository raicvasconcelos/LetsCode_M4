package org.acme.genero;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class GeneroRepository implements PanacheRepository<Genero> {
    public List<Genero> findByName(String name) {
        return find("generoNome = ?1", name).list();
    }
}
