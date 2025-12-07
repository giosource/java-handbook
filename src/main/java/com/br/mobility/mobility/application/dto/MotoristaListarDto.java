package com.br.mobility.mobility.application.dto;

public class MotoristaListarDto {

  private String nome;
  private String telefone;
  private String email;
  private String cnh;
  private String cpf;
  private boolean passe;

  public MotoristaListarDto() {
  }

  public MotoristaListarDto(String nome, String telefone, String email, String cnh, String cpf, boolean passe) {
    this.nome = nome;
    this.telefone = telefone;
    this.email = email;
    this.cnh = cnh;
    this.cpf = cpf;
    this.passe = passe;
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

  public boolean isPasse() {
    return passe;
  }

  public void setPasse(boolean passe) {
    this.passe = passe;
  }

}
