package com.br.ecommerce.ecommerce.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.ecommerce.ecommerce.Entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}
