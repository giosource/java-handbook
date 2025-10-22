package com.br.ecommerce.ecommerce.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.ecommerce.ecommerce.Entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}
