package com.example.musicaProjeto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PlaylistDTO {

    private String playlistNome;
    private int pessoaID;
    private int MusicaID;
}
