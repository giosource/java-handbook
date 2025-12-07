package com.br.mobility.mobility.application.dto;

import jakarta.validation.constraints.NotBlank;

public class CorridaEditarDto {

  @NotBlank
  private Long id;

  @NotBlank
  private Double distancia;

  @NotBlank
  private boolean cancelamento;

  public CorridaEditarDto(@NotBlank Long id, @NotBlank Double distancia, @NotBlank boolean cancelamento) {
    this.id = id;
    this.distancia = distancia;
    this.cancelamento = cancelamento;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Double getDistancia() {
    return distancia;
  }

  public void setDistancia(Double distancia) {
    this.distancia = distancia;
  }

  public boolean isCancelamento() {
    return cancelamento;
  }

  public void setCancelamento(boolean cancelamento) {
    this.cancelamento = cancelamento;
  }

}
