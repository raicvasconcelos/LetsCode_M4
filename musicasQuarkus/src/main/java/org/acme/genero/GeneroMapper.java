package org.acme.genero;

public class GeneroMapper {

    public static GeneroDTO entityToDTO(Genero genero){
        GeneroDTO generoDTO = new GeneroDTO();
        generoDTO.setGeneroNome(genero.getGeneroNome());
        return generoDTO;
    }
}
