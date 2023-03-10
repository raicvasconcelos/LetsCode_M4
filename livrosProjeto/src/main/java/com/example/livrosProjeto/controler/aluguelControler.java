package com.example.livrosProjeto.controler;

import com.example.livrosProjeto.dto.AluguelRequest;
import com.example.livrosProjeto.entity.Aluguel;
import com.example.livrosProjeto.entity.Pessoa;
import com.example.livrosProjeto.repository.AluguelRepository;
import com.example.livrosProjeto.repository.LivroRepository;
import com.example.livrosProjeto.repository.PessoaRepository;
import com.example.livrosProjeto.service.AluguelService;
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

    @Autowired
    private AluguelRepository aluguelRepository;

    @PostMapping("/alugaLivro")
    public Aluguel alugaLivro(@RequestBody AluguelRequest aluguel){
    return aluguelRepository.saveAndFlush(AluguelService.postAluguel(aluguel));
    }
//    @PostMapping("/alugaLivro")
//    public void alugaLivro(@RequestBody String aluguel){
//        return aluguelRepository.save(AluguelService.postAluguel(aluguel));
//    }

    @GetMapping("/listaAlugueis")
    public List<Pessoa> listaAlguel(){
        return pessoaRepository.findAll();
    }
}
