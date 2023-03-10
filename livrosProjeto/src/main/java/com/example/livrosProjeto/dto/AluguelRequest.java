package com.example.livrosProjeto.dto;

import com.example.livrosProjeto.entity.Aluguel;
import com.example.livrosProjeto.entity.Livro;
import com.example.livrosProjeto.entity.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AluguelRequest {

    private Pessoa pessoa;
    private List<Livro> livros;

}
