package com.br.mobility.mobility.application.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class PassageiroCadastrarDto {

  @NotBlank
  @Pattern(regexp = "^[A-Za-z]{2,}\\s[A-Za-z]{2,}+$*")
  @Size(min = 2, max = 100)
  private String nome;

  @NotBlank
  @Pattern(regexp = "\\d{11}")
  private String telefone;

  @NotBlank
  @Email
  @Pattern(regexp = "^[A-Za-z0-9]+@[A-Za-z0-9]+\\.[A-Za-z0-9]+$")
  @Size(min = 5, max = 100)
  private String email;

  @NotBlank
  @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d@$%*#?]{8,}$")
  @Size(min = 8, max = 50)
  private String senha;

  public PassageiroCadastrarDto() {
  }

  public PassageiroCadastrarDto(
      @NotBlank @Pattern(regexp = "^[A-Za-z]{2,}\\s[A-Za-z]{2,}+$*") @Size(min = 2, max = 100) String nome,
      @NotBlank @Pattern(regexp = "\\d{11}") String telefone,
      @NotBlank @Email @Pattern(regexp = "^[A-Za-z0-9]+@[A-Za-z0-9]+\\.[A-Za-z0-9]+$") @Size(min = 5, max = 100) String email,
      @NotBlank @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d@$%*#?]{8,}$") @Size(min = 8, max = 50) String senha) {
    this.nome = nome;
    this.telefone = telefone;
    this.email = email;
    this.senha = senha;
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

}
