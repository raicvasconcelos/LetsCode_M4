package com.example.livrosProjeto.config;

import com.example.livrosProjeto.entity.Aluguel;
import com.example.livrosProjeto.entity.Categoria;
import com.example.livrosProjeto.entity.Livro;
import com.example.livrosProjeto.entity.Pessoa;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Configuration
public class Listas {

    private List<Livro> livros = Collections.synchronizedList(new ArrayList<>());

    private List<Categoria> categorias = Collections.synchronizedList(new ArrayList<>());

    private List<Pessoa> pessoas = Collections.synchronizedList(new ArrayList<>());

    private List<Aluguel> alugueis = Collections.synchronizedList(new ArrayList<>());


    @Bean
   public List<Categoria> listaCategorias(){
        Categoria categoria1 = new Categoria();
        Categoria categoria2 = new Categoria();
        categoria1.setCategoriaNome("Bibliografia");
        categoria1.setLivros(new ArrayList<>());
        categoria2.setCategoriaNome("Ficção");
        categoria2.setLivros(new ArrayList<>());
        categorias.add(categoria1);
        return categorias;
    }

    @Bean
    public List<Livro> listaLivros(){
        Livro livro1 = new Livro();
        livro1.setTitulo("Necromicrom");
        livro1.setAutor("H. P. lovecraft");
        livro1.setAno(1927);
        Categoria ficcao = categorias.stream().filter(categoria -> categoria.equals("Bibliografia")).findAny().orElse(null);
        livro1.setCategoria(ficcao);
        livros.add(livro1);
        return  livros;
    }

    @Bean
    public List<Pessoa> listPessoas(){
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Railson");
        pessoa.setCpf("521313210");
        pessoas.add(pessoa);
        return  pessoas;
    }

    @Bean
    public List<Aluguel> listAlugueis(){
        Aluguel aluguel = new Aluguel();
        aluguel.setPessoa(new Pessoa("Roni", "54651321"));
        aluguel.setLivros(new ArrayList<>());
        aluguel.setDataAluguel(LocalDate.now());
        aluguel.setDataEntrega(LocalDate.now().plusDays(3));
        alugueis.add(aluguel);
        return alugueis;
    }
}
