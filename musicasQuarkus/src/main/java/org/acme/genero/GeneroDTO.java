package org.acme.genero;

import lombok.Data;
import org.acme.musica.Musica;

import javax.persistence.OneToMany;
import java.util.List;

@Data
public class GeneroDTO {

    private String generoNome;


}
