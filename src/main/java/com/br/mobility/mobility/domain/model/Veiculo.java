package com.br.mobility.mobility.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Veiculo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 50, nullable = false)
  private String modelo;

  @Column(length = 20, nullable = false)
  private String cor;

  @Column(length = 20, nullable = false)
  private String tipo;

  @Column(unique = true, length = 7, nullable = false)
  private String placa;

  @OneToOne
  @JoinColumn(name = "motorista")
  private Motorista motorista;

  public Veiculo() {
  }

  public Veiculo(String modelo, String cor, String tipo, String placa, Motorista motorista) {
    this.modelo = modelo;
    this.cor = cor;
    this.tipo = tipo;
    this.placa = placa;
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

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
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

}
