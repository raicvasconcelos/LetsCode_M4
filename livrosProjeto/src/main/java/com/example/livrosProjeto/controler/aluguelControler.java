package com.example.livrosProjeto.controler;

import com.example.livrosProjeto.dto.AluguelRequest;
import com.example.livrosProjeto.entity.Pessoa;
import com.example.livrosProjeto.repository.LivroRepository;
import com.example.livrosProjeto.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class aluguelControler {
    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private LivroRepository livroRepository;

    @PostMapping("/alugaLivro")
    public Pessoa alugaLivro(@RequestBody AluguelRequest aluguel){
        return pessoaRepository.save(aluguel.getPessoa());
    }
    @GetMapping("/listaAlugueis")
    public List<Pessoa> listaAlguel(){
        return pessoaRepository.findAll();
    }
}
