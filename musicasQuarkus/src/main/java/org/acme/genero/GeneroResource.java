package org.acme.genero;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Path("/genero")
@ApplicationScoped
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Tag(name = "Genero", description = "Gerencia os gêneros.")
public class GeneroResource {

    @Inject
    GeneroService generoService;

    @GET
    @Path("/list")
    @Operation(summary = "Lista todos os generos.")
    public Response findAll(@QueryParam("generoNome") String generoNome){

        return Response.ok(generoService.findAll()
                .stream()
                .map(GeneroMapper::entityToDTO)
                .collect(Collectors.toList())
        ).build();
    }


}
