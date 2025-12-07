package com.br.mobility.mobility.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Corrida {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private Double distancia;

  @Column(nullable = false)
  private Double valor;

  @Column(nullable = false)
  private Double valorMotorista;

  @Column(nullable = false)
  private boolean cancelamento;

  @ManyToOne
  @JoinColumn(name = "passageiro")
  private Passageiro passageiro;

  @ManyToOne
  @JoinColumn(name = "motorista")
  private Motorista motorista;

  @ManyToOne
  @JoinColumn(name = "veiculo")
  private Veiculo veiculo;

  public Corrida() {
  }

  public Corrida(Double distancia, Double valor, Double valorMotorista, boolean cancelamento, Passageiro passageiro,
      Motorista motorista, Veiculo veiculo) {
    this.distancia = distancia;
    this.valor = valor;
    this.valorMotorista = valorMotorista;
    this.cancelamento = cancelamento;
    this.passageiro = passageiro;
    this.motorista = motorista;
    this.veiculo = veiculo;
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

  public Double getValor() {
    return valor;
  }

  public void setValor(Double valor) {
    this.valor = valor;
  }

  public Double getValorMotorista() {
    return valorMotorista;
  }

  public void setValorMotorista(Double valorMotorista) {
    this.valorMotorista = valorMotorista;
  }

  public boolean isCancelamento() {
    return cancelamento;
  }

  public void setCancelamento(boolean cancelamento) {
    this.cancelamento = cancelamento;
  }

  public Passageiro getPassageiro() {
    return passageiro;
  }

  public void setPassageiro(Passageiro passageiro) {
    this.passageiro = passageiro;
  }

  public Motorista getMotorista() {
    return motorista;
  }

  public void setMotorista(Motorista motorista) {
    this.motorista = motorista;
  }

  public Veiculo getVeiculo() {
    return veiculo;
  }

  public void setVeiculo(Veiculo veiculo) {
    this.veiculo = veiculo;
  }

}
