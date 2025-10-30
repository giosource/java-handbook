package com.br.ecommerce.ecommerce.Dto;

import java.util.List;

public class CategoriaDto {
    private String nome;
    private List<Integer> produtosId;

    public CategoriaDto() {
    }

    public CategoriaDto(String nome, List<Integer> produtosId) {
        this.nome = nome;
        this.produtosId = produtosId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Integer> getProdutosId() {
        return produtosId;
    }

    public void setProdutosId(List<Integer> produtosId) {
        this.produtosId = produtosId;
    }

}
