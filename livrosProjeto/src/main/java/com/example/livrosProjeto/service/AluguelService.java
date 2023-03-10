package com.example.livrosProjeto.service;


import com.example.livrosProjeto.dto.AluguelRequest;
import com.example.livrosProjeto.entity.Aluguel;
import com.example.livrosProjeto.entity.Livro;
import com.example.livrosProjeto.entity.Pessoa;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AluguelService {


    public static Aluguel postAluguel(AluguelRequest aluguel){
//        Pessoa pessoa = new Pessoa();
//        Livro livro = new Livro();
//        pessoa.setNome(aluguel.getPessoa().getNome());
//        pessoa.setCpf(aluguel.getPessoa().getCpf());
//
//        livro.setAutor(aluguel.getLivro().getAutor());
//        livro.setTitulo(aluguel.getLivro().getTitulo());
//        livro.setAno(aluguel.getLivro().getAno());
//        livro.setCategoria(aluguel.getLivro().getCategoria());
//
        Aluguel aluguel1 = new Aluguel();
//
//        aluguel1.setPessoa(pessoa);
//        aluguel1.setLivros();

        aluguel1.setLivros(aluguel.getLivros());
        aluguel1.setPessoa(aluguel.getPessoa());

        aluguel1.setDataAluguel(LocalDate.now());
        aluguel1.setDataEntrega(LocalDate.now().plusDays(3));

        return aluguel1;
    }

}
