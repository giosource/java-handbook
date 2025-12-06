package com.br.mobility.mobility.domain.service;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.br.mobility.mobility.application.dto.EnderecoCadastrarDto;
import com.br.mobility.mobility.application.dto.EnderecoEditarDto;
import com.br.mobility.mobility.application.dto.EnderecoListarDto;
import com.br.mobility.mobility.application.dto.MotoristaCadastrarDto;
import com.br.mobility.mobility.application.dto.MotoristaEditarDto;
import com.br.mobility.mobility.application.dto.MotoristaListarDto;
import com.br.mobility.mobility.application.mapper.EnderecoMapper;
import com.br.mobility.mobility.application.mapper.MotoristaMapper;
import com.br.mobility.mobility.domain.model.Endereco;
import com.br.mobility.mobility.domain.model.Motorista;
import com.br.mobility.mobility.domain.repository.EnderecoRepository;
import com.br.mobility.mobility.domain.repository.MotoristaRepository;
import com.br.mobility.mobility.exception.BusinessException;

@Service
public class MotoristaService {

  private final MotoristaRepository motoristaRepository;
  private final MotoristaMapper motoristaMapper;
  private final PasswordEncoder passwordEncoder;
  private final EnderecoRepository enderecoRepository;
  private final EnderecoMapper enderecoMapper;

  public MotoristaService(MotoristaRepository motoristaRepository, MotoristaMapper motoristaMapper,
      PasswordEncoder passwordEncoder, EnderecoRepository enderecoRepository,
      EnderecoMapper enderecoMapper) {
    this.motoristaRepository = motoristaRepository;
    this.motoristaMapper = motoristaMapper;
    this.passwordEncoder = passwordEncoder;
    this.enderecoRepository = enderecoRepository;
    this.enderecoMapper = enderecoMapper;
  }

  public Motorista cadastrarMotorista(MotoristaCadastrarDto motoristaCadastroDto) {

    Motorista novoMotorista = motoristaMapper.toEntity(motoristaCadastroDto);

    verificarTelefoneMotorista(novoMotorista.getTelefone(), novoMotorista.getId());
    verificarEmailMotorista(novoMotorista.getEmail(), novoMotorista.getId());

    criptografarSenha(novoMotorista);

    return motoristaRepository.save(novoMotorista);
  }

  public MotoristaListarDto listarMotorista(String email) {

    Motorista motorista = buscarMotoristaEmail(email);
    return motoristaMapper.toDtoListar(motorista);
  }

  public MotoristaEditarDto editarMotorista(String email, MotoristaEditarDto motoristaEditarDto) {
    Motorista motorista = buscarMotoristaEmail(email);

    motoristaMapper.updateEntity(motoristaEditarDto, motorista);

    verificarTelefoneMotorista(motorista.getTelefone(), motorista.getId());
    verificarEmailMotorista(motorista.getEmail(), motorista.getId());

    criptografarSenha(motorista);
    motoristaRepository.save(motorista);
    return motoristaEditarDto;
  }

  public Endereco cadastrarEndereco(String email, EnderecoCadastrarDto enderecoCadastrarDto) {
    Endereco novoEndereco = enderecoMapper.toEntity(enderecoCadastrarDto);
    Motorista motorista = motoristaRepository.findByEmail(email).get();
    motorista.setEndereco(novoEndereco);
    motoristaRepository.save(motorista);
    return enderecoRepository.save(novoEndereco);
  }

  public EnderecoListarDto listarEndereco(String email) {
    return enderecoMapper
        .toDtoListar(motoristaRepository.findByEmail(email).get().getEndereco());
  }

  public EnderecoEditarDto editarEndereco(String email, EnderecoEditarDto enderecoEditarDto) {
    Endereco endereco = enderecoRepository.findById(enderecoEditarDto.getId()).get();
    enderecoMapper.updateEntity(enderecoEditarDto, endereco);
    enderecoRepository.save(endereco);

    Motorista motorista = motoristaRepository.findByEmail(email).get();
    motorista.setEndereco(endereco);
    motoristaRepository.save(motorista);
    return enderecoEditarDto;
  }

  private void verificarTelefoneMotorista(String telefone, Long id) {
    if (telefone == null) {
      throw new BusinessException("Telefone não existente.");
    }

    if (!telefone.matches("\\d{11}")) {
      throw new BusinessException("Telefone sem 11 digitos númericos.");
    }

    if (motoristaRepository.existsByTelefone(telefone) && motoristaRepository.findById(id).get().getId() != id) {
      throw new BusinessException("Telefone existente.");
    }
  }

  private void verificarEmailMotorista(String email, Long id) {
    if (email == null) {
      throw new BusinessException("E-mail não existente.");
    }

    if (motoristaRepository.existsByEmail(email) && motoristaRepository.findById(id).get().getId() != id) {
      throw new BusinessException("E-mail existente.");
    }
  }

  private void criptografarSenha(Motorista Motorista) {
    String senhaHash = passwordEncoder.encode(Motorista.getSenha());
    Motorista.setSenha(senhaHash);
  }

  private Motorista buscarMotoristaEmail(String email) {
    Optional<Motorista> motorista = motoristaRepository.findByEmail(email);

    if (motorista.isEmpty()) {
      throw new BusinessException("Motorista não encontrado.");
    }

    return motorista.get();
  }
}
