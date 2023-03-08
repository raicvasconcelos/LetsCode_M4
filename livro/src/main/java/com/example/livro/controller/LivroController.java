package com.example.livro.controller;


import com.example.livro.dto.LivroAluguel;
import com.example.livro.entity.Pessoa;
import com.example.livro.repository.LivroRepository;
import com.example.livro.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LivroController {
    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private PessoaRepository pessoaRepository;


@PostMapping("/alugaLivro")
    public Pessoa alugaLivro(@RequestBody LivroAluguel aluguel){
      return pessoaRepository.save(aluguel.getPessoa());
    }

//    @PostMapping("/alugaLivro")
//    public void alugaLivro(@RequestBody String aluguel){
//        System.out.println(aluguel);
//    }




}
