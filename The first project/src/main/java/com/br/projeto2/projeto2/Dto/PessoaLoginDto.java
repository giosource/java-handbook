package com.br.projeto2.projeto2.Dto;

public class PessoaLoginDto {
    private String email;
    private String senha;
    
    public PessoaLoginDto() {
    }
    public PessoaLoginDto(String email, String senha) {
        this.email = email;
        this.senha = senha;
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
