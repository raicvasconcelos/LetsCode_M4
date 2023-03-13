package com.example.livrosProjeto.controler;

import com.example.livrosProjeto.dto.LivroDTO;
import com.example.livrosProjeto.entity.Categoria;
import com.example.livrosProjeto.entity.Livro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    private List<Livro> livros = Collections.synchronizedList(new ArrayList<>());

    @Autowired
    private List<Categoria> categorias = Collections.synchronizedList(new ArrayList<>());

    @PostMapping
    public ResponseEntity criaLivro(@RequestBody LivroDTO novolivro) throws Exception {

//        Optional<Categoria> categoria = categorias.stream()
//                .filter(value -> value.equals(novolivro.getLivro().getTitulo()))
//                .findFirst();

        Optional<Categoria> categoriaFind = Optional.ofNullable(categorias.stream().filter(c -> c.getCategoriaNome()
                        .equalsIgnoreCase(novolivro.getLivro().getCategoria().getCategoriaNome()))
                .findFirst().orElseThrow(() -> new Exception("Categoria não encontrada")));

        try{
            Categoria categoriaEncontrado = categoriaFind.orElseThrow(() -> new Exception("Categoria não encontrada"));

            Livro livro =new Livro();
            livro.setTitulo(novolivro.getLivro().getTitulo());
            livro.setAutor(novolivro.getLivro().getAutor());
            livro.setAno(novolivro.getLivro().getAno());
            livro.setCategoria(categoriaEncontrado);
            livros.add(livro);
            return ResponseEntity.ok().body(livro);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }


//        }
//            return ResponseEntity.badRequest().body("categoria não encontrada");



    }
    @GetMapping
    public List<Livro> listaLivros(){
        return livros;
    }
}
