package com.br.projeto2.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.projeto2.Entities.Pessoa;
import java.util.Optional;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
    Optional<Pessoa> findByEmail(String email);
}
