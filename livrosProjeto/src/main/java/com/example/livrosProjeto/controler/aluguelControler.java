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
import java.util.stream.Collectors;

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

//    @PostMapping
//    public ResponseEntity criaAluguel(@RequestBody AluguelDTO novoAluguel) throws Exception {
//
////        Optional<Pessoa> pessoaEncontraNome =pessoas.stream().filter(pessoa -> pessoa.equals())
//
//        boolean pessoaExist = pessoas.contains(novoAluguel.getAluguel().getPessoa().getNome());
//
//        boolean livroExist = livros.contains(novoAluguel.getAluguel().getLivros());
//        Categoria ficcao = categorias.stream().filter(categoria -> categoria.equals("Bibliografia")).findAny().orElse(null);
//        Aluguel aluguel = new Aluguel();
//        if(pessoaExist) {
//            Pessoa pessoaEncontrada = pessoas.stream().filter(p ->{return p.equals(novoAluguel.getAluguel().getPessoa().getNome());}).findAny().orElseThrow(() -> new Exception("Pessoa não encontrada"));
//            aluguel.setPessoa(new Pessoa());
//            aluguel.setLivros(novoAluguel.getAluguel().getLivros());
//            aluguel.setDataAluguel(LocalDate.now());
//            aluguel.setDataEntrega(LocalDate.now().plusDays(3));
//            return ResponseEntity.ok().body(aluguel);
//       }else {return ResponseEntity.badRequest().body("Pessoa não econtrada");}
//
//    }

    @PostMapping
    public ResponseEntity criaAluguel(@RequestBody AluguelDTO novoAluguel) throws Exception {

        Optional<Pessoa> pessoaFind = pessoas.stream().filter(p -> p.getNome()
                .equalsIgnoreCase(novoAluguel.getPessoaNome())).findFirst();

        Pessoa pessoaEncontrada = pessoaFind.orElseThrow(() -> new Exception("Pessoa não encontrada"));

        List<Livro> listalivrosEncontrados = new ArrayList<>();

        for (Livro livroNovos : novoAluguel.getLivroList()) {
            for (Livro livroLista : livros) {
                if (livroNovos.getTitulo().equalsIgnoreCase(livroLista.getTitulo())) {
                    listalivrosEncontrados.add(livroLista);
                    break;
                }
            }
        }

        boolean todosLivrosEncontrados = listalivrosEncontrados.size() == novoAluguel.getLivroList().size();

        if(todosLivrosEncontrados){

         Aluguel aluguel = new Aluguel();
         aluguel.setPessoa(pessoaEncontrada);
         aluguel.setLivros(listalivrosEncontrados);
         aluguel.setDataAluguel(LocalDate.now());
         aluguel.setDataEntrega(LocalDate.now().plusDays(5));

         alugueis.add(aluguel);

         return ResponseEntity.ok().body(aluguel);
        }else{
         return ResponseEntity.badRequest().body("Um ou mais dos livros solicitados não foram encontrados na lista");
     }




    }

    @GetMapping("/{pessoaNome}")
    public ResponseEntity listaLivrosCategoria(@PathVariable String pessoaNome)throws Exception{
        Optional<Pessoa> pessoaFind = pessoas.stream().filter(p -> p.getNome()
                .equalsIgnoreCase(pessoaNome)).findFirst();

        try{
            Pessoa pessoaEncontrada = pessoaFind.orElseThrow(() -> new Exception(
                    "Pessoa " + pessoaNome + " não encontrada"));

            List<Aluguel> aluguelFind = alugueis.stream().filter(aluguel -> aluguel.getPessoa().getNome()
                    .equalsIgnoreCase(pessoaEncontrada.getNome())).collect(Collectors.toList());
            return ResponseEntity.ok(aluguelFind);
        }catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    @GetMapping
    public List<Aluguel> encontraAlugueis(){
        return alugueis;
    }

    @DeleteMapping("/{pessoaNome}")
    public ResponseEntity deletaAluguel(@PathVariable String pessoaNome)throws Exception{
        Optional<Pessoa> pessoaFind = pessoas.stream().filter(p -> p.getNome()
                .equalsIgnoreCase(pessoaNome)).findFirst();


        try{
            Pessoa pessoaEncontrada = pessoaFind.orElseThrow(() -> new Exception(
                    "Pessoa " + pessoaNome + " não encontrada"));

           Aluguel aluguelFind = alugueis.stream().filter(aluguel -> aluguel.getPessoa().getNome()
                           .equalsIgnoreCase(pessoaEncontrada.getNome())).
                   findFirst().
                   orElseThrow(() -> new Exception("Aluguel não encontrado"));

//            Aluguel aluguelEncontrado = aluguelFind.orElseThrow(() -> new Exception("Aluguel não encontrado"));
            alugueis.remove(aluguelFind);

            List<Aluguel> aluguelRestante = alugueis.stream().filter(aluguel -> aluguel.getPessoa().getNome()
                    .equalsIgnoreCase(pessoaEncontrada.getNome())).collect(Collectors.toList());

            return ResponseEntity.ok(aluguelRestante);
        }catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

//    @PostMapping
//    public void criaAluguel(@RequestBody String novoAluguel){
//        System.out.println(novoAluguel);
//    }



}
