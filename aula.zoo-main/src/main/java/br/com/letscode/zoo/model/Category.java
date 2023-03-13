package br.com.letscode.zoo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name="category")
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String uid;

    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    private Collection<Animal> animals = new ArrayList<>();
}
