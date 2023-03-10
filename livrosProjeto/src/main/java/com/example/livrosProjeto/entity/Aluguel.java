package com.example.livrosProjeto.entity;

import com.example.livrosProjeto.repository.LivroRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Aluguel {
    @Id
    @GeneratedValue
    private int id;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Pessoa pessoa;
    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Livro> livros;
    private LocalDate dataAluguel;
    private LocalDate dataEntrega;

    //    @OneToMany(targetEntity = Livro.class, cascade = CascadeType.ALL)
//    @JoinColumn(name="pessoa_fk", referencedColumnName = "id")
}
