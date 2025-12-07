package com.br.mobility.mobility.domain.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Motorista {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 150, nullable = false)
  private String nome;

  @Column(unique = true, length = 11, nullable = false)
  private String telefone;

  @Column(unique = true, nullable = false)
  private String email;

  @Column(nullable = false)
  private String senha;

  @Column(unique = true, length = 9, nullable = false)
  private String cnh;

  @Column(unique = true, length = 11, nullable = false)
  private String cpf;

  @Column(nullable = false)
  private boolean passe;

  @ManyToOne(cascade = CascadeType.PERSIST)
  @JoinColumn(name = "endereco")
  private Endereco endereco;

  @OneToMany
  @JsonIgnore
  private List<Veiculo> veiculos;

  public Motorista() {
  }

  public Motorista(String nome, String telefone, String email, String senha, String cnh, String cpf, boolean passe,
      Endereco endereco, List<Veiculo> veiculos) {
    this.nome = nome;
    this.telefone = telefone;
    this.email = email;
    this.senha = senha;
    this.cnh = cnh;
    this.cpf = cpf;
    this.passe = passe;
    this.endereco = endereco;
    this.veiculos = veiculos;
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

  public String getTelefone() {
    return telefone;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public String getCnh() {
    return cnh;
  }

  public void setCnh(String cnh) {
    this.cnh = cnh;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public Endereco getEndereco() {
    return endereco;
  }

  public void setEndereco(Endereco endereco) {
    this.endereco = endereco;
  }

  public List<Veiculo> getVeiculos() {
    return veiculos;
  }

  public void setVeiculos(List<Veiculo> veiculos) {
    this.veiculos = veiculos;
  }

  public boolean isPasse() {
    return passe;
  }

  public void setPasse(boolean passe) {
    this.passe = passe;
  }

}
