package com.example.livrosProjeto.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Pessoa {

    private String nome;
    private String cpf;
//    @OneToMany(targetEntity = Livro.class, cascade = CascadeType.ALL)
//    @JoinColumn(name="pessoa_fk", referencedColumnName = "id")
//    private List<Livro> livros;



}
