package com.example.musicaProjeto.repository;

import com.example.musicaProjeto.entity.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GeneroRepository extends JpaRepository<Genero, Integer> {
    @Query("SELECT CASE WHEN COUNT(g) > 0 THEN true ELSE false END FROM Genero g WHERE g.generoNome = ?1")
    boolean existsByName(String generoNome);

//    @Query("SELECT CASE WHEN COUNT(g) > 0 THEN true ELSE false END FROM Genero g WHERE g.generoNome = ?1")
//    Genero generoByName (String generoNome);

    @Query("SELECT g FROM Genero g WHERE g.generoNome LIKE %:searchTerm%")


    Genero findBySearchTerm(@Param("searchTerm") String generoNome);
}
