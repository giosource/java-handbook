package com.br.mobility.mobility.application.dto;

public class DependenteListarDto {

    private String nome;

    public DependenteListarDto() {
    }

    public DependenteListarDto(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
