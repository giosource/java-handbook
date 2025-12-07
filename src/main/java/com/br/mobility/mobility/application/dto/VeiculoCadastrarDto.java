package com.br.mobility.mobility.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class VeiculoCadastrarDto {

  @NotBlank
  @Pattern(regexp = "\\w")
  @Size(min = 2, max = 50)
  private String modelo;

  @NotBlank
  @Pattern(regexp = "\\p{Alpha}")
  @Size(min = 4, max = 100)
  private String cor;

  @NotBlank
  @Pattern(regexp = "\\w")
  @Size(min = 7, max = 7)
  private String placa;

  @NotBlank
  private boolean adesivo;

  public VeiculoCadastrarDto() {
  }

  public VeiculoCadastrarDto(@NotBlank @Pattern(regexp = "\\w") @Size(min = 2, max = 50) String modelo,
      @NotBlank @Pattern(regexp = "\\p{Alpha}") @Size(min = 4, max = 100) String cor,
      @NotBlank @Pattern(regexp = "\\w") @Size(min = 7, max = 7) String placa, @NotBlank boolean adesivo) {
    this.modelo = modelo;
    this.cor = cor;
    this.placa = placa;
    this.adesivo = adesivo;
  }

  public String getModelo() {
    return modelo;
  }

  public void setModelo(String modelo) {
    this.modelo = modelo;
  }

  public String getCor() {
    return cor;
  }

  public void setCor(String cor) {
    this.cor = cor;
  }

  public String getPlaca() {
    return placa;
  }

  public void setPlaca(String placa) {
    this.placa = placa;
  }

  public boolean isAdesivo() {
    return adesivo;
  }

  public void setAdesivo(boolean adesivo) {
    this.adesivo = adesivo;
  }

}
