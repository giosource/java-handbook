package com.br.projeto2.projeto2.Dto;

public class PessoaDto {

    private String nome;
    private String email;
    private String senha;
    private int enderecoId;
    
    public PessoaDto() {
    }
    public PessoaDto(String nome, String email, String senha, int enderecoId) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.enderecoId = enderecoId;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
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
    public int getEnderecoId() {
        return enderecoId;
    }
    public void setEnderecoId(int enderecoId) {
        this.enderecoId = enderecoId;
    }

    
}
