package com.br.mobility.mobility.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.mobility.mobility.domain.model.Motorista;
import com.br.mobility.mobility.domain.model.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

  List<Veiculo> findByMotorista(Motorista motorista);

}
