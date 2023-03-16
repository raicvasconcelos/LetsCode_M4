package org.acme.musica;

import org.acme.genero.GeneroMapper;

public class MusicaMapper {

    public static MusicaDTO entityToDTO(Musica musica){
        MusicaDTO musicaDTO = new MusicaDTO();
        musicaDTO.setMusicaNome(musica.musicaNome);
        musicaDTO.setArtista(musica.artista);
        if(musica.genero != null) {
            musicaDTO.setGenero(
                    GeneroMapper.entityToDTO(musica.genero));
        }return musicaDTO;
    }
}
