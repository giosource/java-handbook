package com.br.ecommerce.ecommerce.Dto;

public class EnderecoDto {
    private String cep;
    private int numero;
    private String logradouro;
    private String cidade;
    private String uf;
    private int usuarioId;

    public EnderecoDto() {
    }

    public EnderecoDto(String cep, int numero, String logradouro, String cidade, String uf, int usuarioId) {
        this.cep = cep;
        this.numero = numero;
        this.logradouro = logradouro;
        this.cidade = cidade;
        this.uf = uf;
        this.usuarioId = usuarioId;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

}
