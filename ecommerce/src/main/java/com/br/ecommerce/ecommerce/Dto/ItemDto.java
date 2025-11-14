package com.br.ecommerce.ecommerce.Dto;

public class ItemDto {

    private int produtoId;
    private int pedidoId;

    public ItemDto() {
    }

    public ItemDto(int produtoId, int pedidoId) {
        this.produtoId = produtoId;
        this.pedidoId = pedidoId;
    }

    public int getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(int produtoId) {
        this.produtoId = produtoId;
    }

    public int getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(int pedidoId) {
        this.pedidoId = pedidoId;
    }

}
