package com.br.mobility.mobility.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.mobility.mobility.domain.model.Endereco;
import com.br.mobility.mobility.domain.model.Motorista;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

  List<Endereco> findByMotoristas(Motorista motorista);
}
