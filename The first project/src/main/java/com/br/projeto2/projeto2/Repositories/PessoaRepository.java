package com.br.projeto2.projeto2.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.projeto2.projeto2.Entities.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
    Optional<Pessoa> findByEmail(String email);
}
