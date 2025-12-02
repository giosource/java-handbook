package com.br.mobility.mobility.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.mobility.mobility.domain.model.Passageiro;
import java.util.Optional;

public interface PassageiroRepository extends JpaRepository<Passageiro, Long> {

    Optional<Passageiro> findByEmail(String email);

    boolean existsByTelefone(String telefone);

    boolean existsByEmail(String email);
}
