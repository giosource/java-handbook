package com.br.mobility.mobility.application.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class EnderecoEditarDto {

  @NotBlank
  private Long id;

  @NotBlank
  @Pattern(regexp = "\\d{8}")
  @Size(min = 8, max = 8)
  private String cep;

  @NotBlank
  @Size(min = 3, max = 100)
  private String rua;

  @NotBlank
  @Pattern(regexp = "\\d")
  @Size(min = 1, max = 10)
  private String numero;

  @NotBlank
  @Size(min = 3, max = 50)
  private String bairro;

  @NotBlank
  @Size(min = 3, max = 1000)
  private String cidade;

  public EnderecoEditarDto() {
  }

  public EnderecoEditarDto(@NotBlank Long id, @NotBlank @Pattern(regexp = "\\d{8}") @Size(min = 8, max = 8) String cep,
      @NotBlank @Size(min = 3, max = 100) String rua,
      @NotBlank @Email @Pattern(regexp = "\\d") @Size(min = 1, max = 10) String numero,
      @NotBlank @Size(min = 3, max = 50) String bairro, @NotBlank @Size(min = 3, max = 1000) String cidade) {
    this.id = id;
    this.cep = cep;
    this.rua = rua;
    this.numero = numero;
    this.bairro = bairro;
    this.cidade = cidade;
  }

  public String getCep() {
    return cep;
  }

  public void setCep(String cep) {
    this.cep = cep;
  }

  public String getRua() {
    return rua;
  }

  public void setRua(String rua) {
    this.rua = rua;
  }

  public String getNumero() {
    return numero;
  }

  public void setNumero(String numero) {
    this.numero = numero;
  }

  public String getBairro() {
    return bairro;
  }

  public void setBairro(String bairro) {
    this.bairro = bairro;
  }

  public String getCidade() {
    return cidade;
  }

  public void setCidade(String cidade) {
    this.cidade = cidade;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

}
