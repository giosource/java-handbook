package com.br.mobility.mobility.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.mobility.mobility.application.dto.EnderecoCadastrarDto;
import com.br.mobility.mobility.application.dto.EnderecoEditarDto;
import com.br.mobility.mobility.application.dto.EnderecoListarDto;
import com.br.mobility.mobility.application.dto.MotoristaCadastrarDto;
import com.br.mobility.mobility.application.dto.MotoristaEditarDto;
import com.br.mobility.mobility.application.dto.MotoristaListarDto;
import com.br.mobility.mobility.domain.service.MotoristaService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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

  @GetMapping("/listar")
  public MotoristaListarDto listarMotorista(@AuthenticationPrincipal UserDetails userDetails) {
    String emailMotorista = userDetails.getUsername();
    return motoristaService.listarMotorista(emailMotorista);
  }

  @PutMapping("/editar")
  public MotoristaEditarDto editarMotorista(@AuthenticationPrincipal UserDetails userDetails,
      @RequestBody MotoristaEditarDto motoristaEditarDto) {
    String emailMotorista = userDetails.getUsername();
    MotoristaEditarDto motorista = motoristaService.editarMotorista(emailMotorista, motoristaEditarDto);
    return motorista;
  }

  @PostMapping("/cadastrar/endereco")
  public String cadastrarEndereco(@AuthenticationPrincipal UserDetails userDetails,
      @RequestBody EnderecoCadastrarDto enderecoCadastrarDto) {
    String emailMotorista = userDetails.getUsername();
    motoristaService.cadastrarEndereco(emailMotorista, enderecoCadastrarDto);
    return "Endereco cadastrado.";
  }

  @PostMapping("/listar/endereco")
  public EnderecoListarDto listarEndereco(@AuthenticationPrincipal UserDetails userDetails) {
    String emailMotorista = userDetails.getUsername();
    return motoristaService.listarEndereco(emailMotorista);
  }

  @PostMapping("/editar/endereco")
  public String editarEndereco(@AuthenticationPrincipal UserDetails userDetails,
      @RequestBody EnderecoEditarDto enderecoEditarDto) {
    String emailMotorista = userDetails.getUsername();
    motoristaService.editarEndereco(emailMotorista, enderecoEditarDto);
    return "Endereco editado.";
  }

}
