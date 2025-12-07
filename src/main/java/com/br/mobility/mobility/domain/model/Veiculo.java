package com.br.mobility.mobility.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Veiculo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 50, nullable = false)
  private String modelo;

  @Column(length = 20, nullable = false)
  private String cor;

  @Column(length = 7, nullable = false)
  private String placa;

  @Column(nullable = false)
  private boolean adesivo;

  @ManyToOne
  @JoinColumn(name = "motorista")
  private Motorista motorista;

  public Veiculo() {
  }

  public Veiculo(String modelo, String cor, String placa, boolean adesivo, Motorista motorista) {
    this.modelo = modelo;
    this.cor = cor;
    this.placa = placa;
    this.adesivo = adesivo;
    this.motorista = motorista;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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

  public Motorista getMotorista() {
    return motorista;
  }

  public void setMotorista(Motorista motorista) {
    this.motorista = motorista;
  }

  public boolean isAdesivo() {
    return adesivo;
  }

  public void setAdesivo(boolean adesivo) {
    this.adesivo = adesivo;
  }

}
