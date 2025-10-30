package com.br.ecommerce.ecommerce.Dto;

public class ProdutoDto {

    private String nome;
    private String especificacao;
    private double preco;
    private int estoque;
    private boolean disponibilidade;
    private int categoriaId;
    private int pedidoId;

    public ProdutoDto() {
    }

    public ProdutoDto(String nome, String especificacao, double preco, int estoque, boolean disponibilidade,
            int categoriaId, int pedidoId) {
        this.nome = nome;
        this.especificacao = especificacao;
        this.preco = preco;
        this.estoque = estoque;
        this.disponibilidade = disponibilidade;
        this.categoriaId = categoriaId;
        this.pedidoId = pedidoId;
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

    public int getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(int pedidoId) {
        this.pedidoId = pedidoId;
    }

}
