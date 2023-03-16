package org.acme.musica;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class MusicaService {

    @Inject
    MusicaRepository musicaRepository;

    public List<Musica> findAll(){
        return musicaRepository.findAll().list();
    }

    public Musica findByName(String musicaNome) { return musicaRepository.findByName(musicaNome);  }
}
