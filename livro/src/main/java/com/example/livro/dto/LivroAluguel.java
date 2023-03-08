package com.example.livro.dto;

import com.example.livro.entity.Livro;
import com.example.livro.entity.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LivroAluguel {

    private Pessoa pessoa;
}
