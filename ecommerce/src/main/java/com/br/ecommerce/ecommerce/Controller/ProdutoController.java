package com.br.ecommerce.ecommerce.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.ecommerce.ecommerce.Dto.ProdutoDto;
import com.br.ecommerce.ecommerce.Entities.Categoria;
import com.br.ecommerce.ecommerce.Entities.Produto;
import com.br.ecommerce.ecommerce.Repositories.CategoriaRepository;
import com.br.ecommerce.ecommerce.Repositories.PedidoRepository;
import com.br.ecommerce.ecommerce.Repositories.ProdutoRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    PedidoRepository pedidoRepository;

    @PostMapping("/salvar")
    public String salvar(@RequestBody ProdutoDto produtoDto) {

        Produto produto = new Produto(produtoDto.getNome(), produtoDto.getEspecificacao(), produtoDto.getPreco(),
                produtoDto.getEstoque(), produtoDto.isDisponibilidade(),
                categoriaRepository.findById(produtoDto.getCategoriaId()).get(),
                pedidoRepository.findById(produtoDto.getPedidoId()).get());
        produtoRepository.save(produto);
        return "Produto cadastrado!";
    }

    @GetMapping("/listar")
    public List<Produto> listar() {
        List<Produto> produtos = produtoRepository.findAll();
        return produtos;
    }

    @PutMapping("/editar/{idProduto}/{idCategoria}/{idPedido}")
    public String editar(@PathVariable int idProduto, @PathVariable int idCategoria, @PathVariable int idPedido,
            @RequestBody Produto novoProduto) {
        Produto produto = produtoRepository.findById(idProduto).get();
        produto.setNome(novoProduto.getNome());
        produto.setEspecificacao(novoProduto.getEspecificacao());
        produto.setPreco(novoProduto.getPreco());
        produto.setEstoque(novoProduto.getEstoque());
        produto.setDisponibilidade(novoProduto.isDisponibilidade());
        produto.setCategoria(categoriaRepository.findById(idCategoria).get());
        produto.setPedido(pedidoRepository.findById(idPedido).get());
        produtoRepository.save(produto);
        return "Produto editado!";
    }

    @DeleteMapping("/deletar/{idProduto}")
    public String deletarPorId(@PathVariable int idProduto) {
        if (produtoRepository.existsById(idProduto)) {
            produtoRepository.deleteById(idProduto);
            return "Produto deletado!";
        } else {
            return "Produto inexistente!";
        }
    }

}
