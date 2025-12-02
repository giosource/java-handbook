package com.br.mobility.mobility.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Dependente {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 150, nullable = false)
  private String nome;

  @ManyToOne
  @JoinColumn(name = "passageiro")
  private Passageiro passageiro;

  public Dependente() {
  }

  public Dependente(String nome, Passageiro passageiro) {
    this.nome = nome;
    this.passageiro = passageiro;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Passageiro getPassageiro() {
    return passageiro;
  }

  public void setPassageiro(Passageiro passageiro) {
    this.passageiro = passageiro;
  }

}
