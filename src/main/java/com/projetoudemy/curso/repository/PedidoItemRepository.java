package com.projetoudemy.curso.repository;

import com.projetoudemy.curso.entities.PedidoItem;
import com.projetoudemy.curso.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoItemRepository extends JpaRepository<PedidoItem, Long> {
}
