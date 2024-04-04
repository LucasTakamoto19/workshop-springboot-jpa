package com.projetoudemy.curso.repository;

import com.projetoudemy.curso.entities.Categoria;
import com.projetoudemy.curso.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
