package com.projetoudemy.curso.repository;

import com.projetoudemy.curso.entities.Categoria;
import com.projetoudemy.curso.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
