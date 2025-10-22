package com.br.ecommerce.ecommerce.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.ecommerce.ecommerce.Entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
