package com.example.demo.RestController;


import com.example.demo.Livros.DadosCadastroLivro;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @GetMapping
    public String getLivros(){
        return("livros");
    }

    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroLivro dados){
        System.out.println(dados.toString());

    }

}