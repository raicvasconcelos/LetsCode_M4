package org.acme.musica;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Path("/musica")
@ApplicationScoped
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Tag(name = "musica", description = "Gerencia as musicas.")
public class MusicaResource {

    @Inject
    private MusicaService musicaService;

    @GET
    @Path("/list")
    @Operation(summary = "Lista todas as musicas.")
    public Response findAll(@QueryParam("musicaNome") String musicaNome){
        return Response.ok(
                musicaService.findAll()
                .stream().map(MusicaMapper::entityToDTO)
                .collect(Collectors.toList())
        ).build();
    }
}
