package com.br.projeto2.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.projeto2.Entities.Produto;
import com.br.projeto2.Repositories.ProdutoRepository;


@RestController
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    ProdutoRepository ProdutoRepository;

    @PostMapping("/salvar")
    public void salvar2(@RequestBody Produto Produto) {
        ProdutoRepository.save(Produto);
    }
    
    @GetMapping("/listar")
    public void listar() {
        List<Produto> Produtos = ProdutoRepository.findAll();
        for (Produto Produto : Produtos) {
            System.out.println(
                "Nome:" + Produto.getNome() + "\n" +
                "Preco venda:" + Produto.getPrecoVenda() + "\n" +
                "Preco custo:" + Produto.getPrecoCusto() + "\n" +
                "Estoque:" + Produto.getEstoque() + "\n"
            );
        }
    }

    @DeleteMapping("/deletar/{idProduto}")
    public void deletarPorId(@PathVariable int idProduto) {
        if (produtoRepository.existsById(idProduto)) {
            produtoRepository.deleteById(idProduto);
        }
    }
}
