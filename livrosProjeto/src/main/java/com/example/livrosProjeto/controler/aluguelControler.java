package com.example.livrosProjeto.controler;

import com.example.livrosProjeto.dto.AluguelDTO;
import com.example.livrosProjeto.dto.AluguelRequest;
import com.example.livrosProjeto.entity.Aluguel;
import com.example.livrosProjeto.entity.Categoria;
import com.example.livrosProjeto.entity.Livro;
import com.example.livrosProjeto.entity.Pessoa;
//import com.example.livrosProjeto.repository.LivroRepository;
//import com.example.livrosProjeto.repository.PessoaRepository;
import com.example.livrosProjeto.service.AluguelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/aluguel")
public class aluguelControler {

    @Autowired
    private List<Livro> livros = Collections.synchronizedList(new ArrayList<>());

    @Autowired
    private List<Categoria> categorias = Collections.synchronizedList(new ArrayList<>());

    @Autowired
    private List<Pessoa> pessoas = Collections.synchronizedList(new ArrayList<>());

    @Autowired
    private List<Aluguel> alugueis = Collections.synchronizedList(new ArrayList<>());

    @PostMapping
    public ResponseEntity criaAluguel(@RequestBody AluguelDTO novoAluguel) throws Exception {

//        Optional<Pessoa> pessoaEncontraNome =pessoas.stream().filter(pessoa -> pessoa.equals())

        boolean pessoaExist = pessoas.contains(novoAluguel.getAluguel().getPessoa().getNome());

        boolean livroExist = livros.contains(novoAluguel.getAluguel().getLivros());
        Categoria ficcao = categorias.stream().filter(categoria -> categoria.equals("Bibliografia")).findAny().orElse(null);
        Aluguel aluguel = new Aluguel();
        if(pessoaExist) {
            Pessoa pessoaEncontrada = pessoas.stream().filter(p ->{return p.equals(novoAluguel.getAluguel().getPessoa().getNome());}).findAny().orElseThrow(() -> new Exception("Pessoa não encontrada"));
            aluguel.setPessoa(new Pessoa());
            aluguel.setLivros(novoAluguel.getAluguel().getLivros());
            aluguel.setDataAluguel(LocalDate.now());
            aluguel.setDataEntrega(LocalDate.now().plusDays(3));
            return ResponseEntity.ok().body(aluguel);
       }else {return ResponseEntity.badRequest().body("Pessoa não econtrada");}



    }

//    @PostMapping
//    public void criaAluguel(@RequestBody String novoAluguel){
//        System.out.println(novoAluguel);
//    }



}
