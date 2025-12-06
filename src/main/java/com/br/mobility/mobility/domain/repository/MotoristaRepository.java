package com.br.mobility.mobility.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.mobility.mobility.domain.model.Motorista;

public interface MotoristaRepository extends JpaRepository<Motorista, Long> {

  Optional<Motorista> findByEmail(String email);

  boolean existsByTelefone(String telefone);

  boolean existsByEmail(String email);
}
