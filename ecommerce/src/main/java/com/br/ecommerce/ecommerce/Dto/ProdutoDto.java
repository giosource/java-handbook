package com.br.ecommerce.ecommerce.Dto;

import java.util.List;

public class ProdutoDto {

    private String nome;
    private String especificacao;
    private double preco;
    private int estoque;
    private boolean disponibilidade;
    private int categoriaId;
    private List<Integer> itensId;

    public ProdutoDto() {
    }

    public ProdutoDto(String nome, String especificacao, double preco, int estoque, boolean disponibilidade,
            int categoriaId, List<Integer> itensId) {
        this.nome = nome;
        this.especificacao = especificacao;
        this.preco = preco;
        this.estoque = estoque;
        this.disponibilidade = disponibilidade;
        this.categoriaId = categoriaId;
        this.itensId = itensId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecificacao() {
        return especificacao;
    }

    public void setEspecificacao(String especificacao) {
        this.especificacao = especificacao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public int getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
    }

    public List<Integer> getItensId() {
        return itensId;
    }

    public void setItensId(List<Integer> itensId) {
        this.itensId = itensId;
    }

}
