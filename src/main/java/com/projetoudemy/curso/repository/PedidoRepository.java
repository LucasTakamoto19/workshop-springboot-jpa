package com.projetoudemy.curso.repository;

import com.projetoudemy.curso.entities.Pedido;
import com.projetoudemy.curso.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
