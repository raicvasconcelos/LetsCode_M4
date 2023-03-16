package org.acme.playlist;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import org.acme.genero.Genero;
import org.acme.genero.GeneroRepository;
import org.acme.genero.GeneroService;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

@ApplicationScoped
public class LifecycleBean {

    @Inject
    public GeneroRepository generoRepository;

    @Inject
    public GeneroService generoService;

    private static final Logger LOGGER = Logger.getLogger("MyLifecycleBean");

    public void onStart(@Observes StartupEvent ev){
        Genero genero1 = new Genero();
        genero1.setGeneroNome("Dream Pop");
        generoService.create(genero1);
        Genero genero2 = new Genero();
        genero2.setGeneroNome("Metal Progressivo");
        generoService.create(genero2);
        Genero genero3 = new Genero();
        genero3.setGeneroNome("Post-Punk Sovietico");
        generoService.create(genero3);
    }

    public void onStop(@Observes ShutdownEvent ev) {
        LOGGER.fatal("QUARKUS FINALIZOU!!!");
    }
}
