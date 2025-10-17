package com.br.projeto2.projeto2.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.projeto2.projeto2.Entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
