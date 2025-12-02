package com.br.mobility.mobility.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.mobility.mobility.domain.model.Dependente;
import com.br.mobility.mobility.domain.model.Passageiro;

public interface DependenteRepository extends JpaRepository<Dependente, Long> {

  List<Dependente> findByPassageiro(Passageiro passageiro);
}
