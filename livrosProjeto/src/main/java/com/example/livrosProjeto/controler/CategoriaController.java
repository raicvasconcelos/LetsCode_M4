package com.example.livrosProjeto.controler;

import com.example.livrosProjeto.config.Listas;
import com.example.livrosProjeto.dto.CategoriaDTO;
import com.example.livrosProjeto.entity.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private List<Categoria> categorias = Collections.synchronizedList(new ArrayList<>());

    @Autowired
    private Listas listaCategoria;

    @PostMapping
    public ResponseEntity criaCategoria(@RequestBody CategoriaDTO novaCategoria){
        Categoria categoria = new Categoria();
        categoria.setCategoriaNome(novaCategoria.getCategoria().getCategoriaNome());
        categoria.setLivros(new ArrayList<>());
        categorias.add(categoria);
        return ResponseEntity.ok().body(categoria);
    }

    @GetMapping
    public List<Categoria> listaCategorias(){

        return categorias;

    }
}
