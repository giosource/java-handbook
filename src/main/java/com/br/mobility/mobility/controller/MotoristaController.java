package com.br.mobility.mobility.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.mobility.mobility.application.dto.EnderecoCadastrarDto;
import com.br.mobility.mobility.application.dto.EnderecoEditarDto;
import com.br.mobility.mobility.application.dto.EnderecoListarDto;
import com.br.mobility.mobility.application.dto.MotoristaCadastrarDto;
import com.br.mobility.mobility.application.dto.MotoristaEditarDto;
import com.br.mobility.mobility.application.dto.MotoristaListarDto;
import com.br.mobility.mobility.application.dto.VeiculoCadastrarDto;
import com.br.mobility.mobility.application.dto.VeiculoEditarDto;
import com.br.mobility.mobility.application.dto.VeiculoListarDto;
import com.br.mobility.mobility.domain.service.MotoristaService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/motorista")
public class MotoristaController {

  private final MotoristaService motoristaService;

  public MotoristaController(MotoristaService motoristaService) {
    this.motoristaService = motoristaService;
  }

  @PostMapping("/cadastrar")
  public String cadastrarMotorista(@RequestBody MotoristaCadastrarDto motoristaCadastrarDto) {
    motoristaService.cadastrarMotorista(motoristaCadastrarDto);
    return "Motorista cadastrado.";
  }

  @PreAuthorize("hasRole('MOTORISTA')")
  @GetMapping("/listar")
  public MotoristaListarDto listarMotorista(@AuthenticationPrincipal UserDetails userDetails) {
    String emailMotorista = userDetails.getUsername();
    return motoristaService.listarMotorista(emailMotorista);
  }

  @PreAuthorize("hasRole('MOTORISTA')")
  @PutMapping("/editar")
  public MotoristaEditarDto editarMotorista(@AuthenticationPrincipal UserDetails userDetails,
      @RequestBody MotoristaEditarDto motoristaEditarDto) {
    String emailMotorista = userDetails.getUsername();
    MotoristaEditarDto motorista = motoristaService.editarMotorista(emailMotorista, motoristaEditarDto);
    return motorista;
  }

  @PreAuthorize("hasRole('MOTORISTA')")
  @PostMapping("/cadastrar/endereco")
  public String cadastrarEndereco(@AuthenticationPrincipal UserDetails userDetails,
      @RequestBody EnderecoCadastrarDto enderecoCadastrarDto) {
    String emailMotorista = userDetails.getUsername();
    motoristaService.cadastrarEndereco(emailMotorista, enderecoCadastrarDto);
    return "Endereco cadastrado.";
  }

  @PreAuthorize("hasRole('MOTORISTA')")
  @PostMapping("/listar/endereco")
  public EnderecoListarDto listarEndereco(@AuthenticationPrincipal UserDetails userDetails) {
    String emailMotorista = userDetails.getUsername();
    return motoristaService.listarEndereco(emailMotorista);
  }

  @PreAuthorize("hasRole('MOTORISTA')")
  @PostMapping("/editar/endereco")
  public String editarEndereco(@AuthenticationPrincipal UserDetails userDetails,
      @RequestBody EnderecoEditarDto enderecoEditarDto) {
    String emailMotorista = userDetails.getUsername();
    motoristaService.editarEndereco(emailMotorista, enderecoEditarDto);
    return "Endereco editado.";
  }

  @PreAuthorize("hasRole('MOTORISTA')")
  @PostMapping("/cadastrar/veiculo")
  public String cadastrarVeiculo(@AuthenticationPrincipal UserDetails userDetails,
      @RequestBody VeiculoCadastrarDto veiculoCadastrarDto) {
    String emailMotorista = userDetails.getUsername();
    motoristaService.cadastrarVeiculo(emailMotorista, veiculoCadastrarDto);
    return "Veículo cadastrado.";
  }

  @PreAuthorize("hasRole('MOTORISTA')")
  @PostMapping("/listar/veiculo")
  public List<VeiculoListarDto> listarVeiculos(@AuthenticationPrincipal UserDetails userDetails) {
    String emailMotorista = userDetails.getUsername();
    return motoristaService.listarVeiculos(emailMotorista);
  }

  @PreAuthorize("hasRole('MOTORISTA')")
  @PostMapping("/editar/veiculo")
  public String editarVeiculo(@AuthenticationPrincipal UserDetails userDetails,
      @RequestBody VeiculoEditarDto veiculoEditarDto) {
    String emailMotorista = userDetails.getUsername();
    motoristaService.editarVeiculo(emailMotorista, veiculoEditarDto);
    return "Veículo editado.";
  }
}
