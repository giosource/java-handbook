package com.br.mobility.mobility.application.dto;

public class VeiculoListarDto {
  private String modelo;
  private String cor;
  private String placa;
  private boolean adesivo;

  public VeiculoListarDto() {
  }

  public VeiculoListarDto(String modelo, String cor, String placa, boolean adesivo) {
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
