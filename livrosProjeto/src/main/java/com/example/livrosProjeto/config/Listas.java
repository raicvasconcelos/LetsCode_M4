package com.example.livrosProjeto.config;

import com.example.livrosProjeto.entity.Categoria;
import com.example.livrosProjeto.entity.Livro;
import com.example.livrosProjeto.entity.Pessoa;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Configuration
public class Listas {

    private List<Livro> livros = Collections.synchronizedList(new ArrayList<>());

    private List<Pessoa> pessoas = Collections.synchronizedList(new ArrayList<>());

    @Bean
    private List<Livro> listaLivros(){
        Livro livro1 = new Livro();
        livro1.setTitulo("teste");
        livro1.setAutor("teste");
        livro1.setAno(1999);
        livro1.setCategoria(Categoria.BIOGRAFIA);
        livros.add(livro1);
        return  livros;
    }
}
