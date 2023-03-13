package com.example.livrosProjeto.controler;

import com.example.livrosProjeto.dto.LivroDTO;
import com.example.livrosProjeto.dto.PessoaDTO;
import com.example.livrosProjeto.entity.Livro;
import com.example.livrosProjeto.entity.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
    @Autowired
    private List<Pessoa> pessoas = Collections.synchronizedList(new ArrayList<>());

    @PostMapping
    public ResponseEntity criaLivro(@RequestBody PessoaDTO novaPessoa){
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(novaPessoa.getPessoa().getNome());
        pessoa.setCpf(novaPessoa.getPessoa().getCpf());
        pessoas.add(pessoa);
        return ResponseEntity.ok().body(pessoa);
    }
    @GetMapping
    public List<Pessoa> listapessoas(){
        return pessoas;
    }
}
