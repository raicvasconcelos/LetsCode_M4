package org.acme.musica;

import lombok.Data;
import org.acme.genero.Genero;
import org.acme.genero.GeneroDTO;

@Data
public class MusicaDTO {

    private String musicaNome;

    private String artista;

    private GeneroDTO genero;
}
