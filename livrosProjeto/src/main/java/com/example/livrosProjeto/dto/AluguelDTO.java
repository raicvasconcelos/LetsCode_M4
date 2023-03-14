package com.example.livrosProjeto.dto;

import com.example.livrosProjeto.entity.Aluguel;
import com.example.livrosProjeto.entity.Livro;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AluguelDTO {

//    private Aluguel aluguel;
    private String pessoaNome;
//    private String livroTitulo;
    private List<Livro> livroList;
}

