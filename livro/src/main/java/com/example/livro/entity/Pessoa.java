package com.example.livro.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pessoa {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String cpf;
    private int age;

    @OneToMany(targetEntity = Livro.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "livro_fk", referencedColumnName = "id")
    private List<Livro> livros;
}
