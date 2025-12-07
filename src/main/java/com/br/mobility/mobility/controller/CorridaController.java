package com.br.mobility.mobility.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.mobility.mobility.application.dto.CorridaCadastrarDto;
import com.br.mobility.mobility.application.dto.CorridaEditarDto;
import com.br.mobility.mobility.domain.service.CorridaService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/corrida")
public class CorridaController {

  private final CorridaService corridaService;

  public CorridaController(CorridaService corridaService) {
    this.corridaService = corridaService;
  }

  // @PreAuthorize("hasRole('SISTEMA')")
  @PostMapping("/cadastrar")
  public String cadastrarPassageiro(@RequestBody CorridaCadastrarDto corridaCadastrarDto) {
    corridaService.cadastrarCorrida(corridaCadastrarDto);
    return "Corrida cadastrada.";
  }

  @PreAuthorize("hasRole('PASSAGEIRO') or hasRole('MOTORISTA')")
  @PutMapping("/editar")
  public CorridaEditarDto editarPassageiro(@AuthenticationPrincipal UserDetails userDetails,
      @RequestBody CorridaEditarDto corridaEditarDto) {
    String email = userDetails.getUsername();
    return corridaService.editarCorrida(email, corridaEditarDto);
  }
}
