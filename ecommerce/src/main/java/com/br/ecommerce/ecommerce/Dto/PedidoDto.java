package com.br.ecommerce.ecommerce.Dto;

import java.util.List;

public class PedidoDto {
    private String localizacao;
    private double valor;
    private boolean cancelamento;
    private int usuarioId;
    private List<Integer> produtosId;

    public PedidoDto() {
    }

    public PedidoDto(String localizacao, double valor, boolean cancelamento, int usuarioId, List<Integer> produtosId) {
        this.localizacao = localizacao;
        this.valor = valor;
        this.cancelamento = cancelamento;
        this.usuarioId = usuarioId;
        this.produtosId = produtosId;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean isCancelamento() {
        return cancelamento;
    }

    public void setCancelamento(boolean cancelamento) {
        this.cancelamento = cancelamento;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public List<Integer> getProdutosId() {
        return produtosId;
    }

    public void setProdutosId(List<Integer> produtosId) {
        this.produtosId = produtosId;
    }

}
