package com.br.mobility.mobility.application.dto;

import jakarta.validation.constraints.NotBlank;

public class CorridaCadastrarDto {

  @NotBlank
  private Double distancia;

  @NotBlank
  private Long motoristaId;

  @NotBlank
  private Long passageiroId;

  @NotBlank
  private Long veiculoId;

  public Double getDistancia() {
    return distancia;
  }

  public CorridaCadastrarDto(@NotBlank Double distancia, @NotBlank Long motoristaId, @NotBlank Long passageiroId,
      @NotBlank Long veiculoId) {
    this.distancia = distancia;
    this.motoristaId = motoristaId;
    this.passageiroId = passageiroId;
    this.veiculoId = veiculoId;
  }

  public void setDistancia(Double distancia) {
    this.distancia = distancia;
  }

  public Long getMotoristaId() {
    return motoristaId;
  }

  public void setMotoristaId(Long motoristaId) {
    this.motoristaId = motoristaId;
  }

  public Long getPassageiroId() {
    return passageiroId;
  }

  public void setPassageiroId(Long passageiroId) {
    this.passageiroId = passageiroId;
  }

  public Long getVeiculoId() {
    return veiculoId;
  }

  public void setVeiculoId(Long veiculoId) {
    this.veiculoId = veiculoId;
  }

}
