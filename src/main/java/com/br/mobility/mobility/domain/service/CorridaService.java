package com.br.mobility.mobility.domain.service;

import org.springframework.stereotype.Service;

import com.br.mobility.mobility.application.dto.CorridaCadastrarDto;
import com.br.mobility.mobility.application.dto.CorridaEditarDto;
import com.br.mobility.mobility.application.mapper.CorridaMapper;
import com.br.mobility.mobility.domain.model.Corrida;
import com.br.mobility.mobility.domain.repository.CorridaRepository;
import com.br.mobility.mobility.domain.repository.MotoristaRepository;
import com.br.mobility.mobility.domain.repository.PassageiroRepository;
import com.br.mobility.mobility.domain.repository.VeiculoRepository;

@Service
public class CorridaService {

  private final PassageiroRepository passageiroRepository;
  private final MotoristaRepository motoristaRepository;
  private final CorridaRepository corridaRepository;
  private final CorridaMapper corridaMapper;
  private final VeiculoRepository veiculoRepository;

  public CorridaService(CorridaRepository corridaRepository, CorridaMapper corridaMapper,
      VeiculoRepository veiculoRepository, MotoristaRepository motoristaRepository,
      PassageiroRepository passageiroRepository) {
    this.corridaRepository = corridaRepository;
    this.corridaMapper = corridaMapper;
    this.veiculoRepository = veiculoRepository;
    this.motoristaRepository = motoristaRepository;
    this.passageiroRepository = passageiroRepository;
  }

  public Corrida cadastrarCorrida(CorridaCadastrarDto corridaCadastrarDto) {

    Corrida novaCorrida = corridaMapper.toEntity(corridaCadastrarDto);
    novaCorrida.setCancelamento(false);
    novaCorrida.setVeiculo(veiculoRepository.findById(corridaCadastrarDto.getVeiculoId()).get());
    novaCorrida.setMotorista(motoristaRepository.findById(corridaCadastrarDto.getMotoristaId()).get());
    novaCorrida.setPassageiro(passageiroRepository.findById(corridaCadastrarDto.getPassageiroId()).get());

    if (novaCorrida.getDistancia() <= 8) {
      novaCorrida.setValor(2 * novaCorrida.getDistancia());
    } else {
      novaCorrida.setValor(1.9 * novaCorrida.getDistancia());
    }

    if (novaCorrida.getVeiculo().isAdesivo()) {
      double taxa = 0.9;
      novaCorrida.setValorMotorista(novaCorrida.getValor() * taxa);
    } else if (novaCorrida.getMotorista().isPasse()) {
      novaCorrida.setValorMotorista(novaCorrida.getValor() - 0.3);
    } else {
      double taxa = 0.83;
      novaCorrida.setValorMotorista(novaCorrida.getValor() * taxa);
    }

    return corridaRepository.save(novaCorrida);
  }

  public CorridaEditarDto editarCorrida(String email, CorridaEditarDto corridaEditarDto) {
    Corrida corrida = corridaRepository.findById(corridaEditarDto.getId()).get();

    corridaMapper.updateEntity(corridaEditarDto, corrida);

    corridaRepository.save(corrida);
    return corridaEditarDto;
  }
}
