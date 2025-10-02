package com.br.projeto2.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.projeto2.Entities.Produto;
import com.br.projeto2.Repositories.ProdutoRepository;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    ProdutoRepository produtoRepository;

    @PostMapping("/salvar")
    public void salvar(@RequestBody Produto produto) {
        produtoRepository.save(produto);
    }

    @GetMapping("/listar")
    public void listar() {
        List<Produto> produtos = produtoRepository.findAll();
        for (Produto produto : produtos) {
            System.out.println(
                    "Nome:" + produto.getNome() + "\n" +
                            "Preco venda:" + produto.getPrecoVenda() + "\n" +
                            "Preco custo:" + produto.getPrecoCusto() + "\n" +
                            "Estoque:" + produto.getEstoque() + "\n");
        }
    }

    @DeleteMapping("/deletar/{idProduto}")
    public void deletarPorId(@PathVariable int idProduto) {
        if (produtoRepository.existsById(idProduto)) {
            produtoRepository.deleteById(idProduto);
        }
    }

    @PutMapping("/editar/{idProduto}")
    public void editar(@PathVariable int idProduto, @RequestBody Produto novoProduto) {
        Produto produto = produtoRepository.findById(idProduto).get();
        produto.setNome(novoProduto.getNome());
        produto.setPrecoVenda(novoProduto.getPrecoVenda());
        produto.setPrecoCusto(novoProduto.getPrecoCusto());
        produto.setEstoque(novoProduto.getEstoque());
        produtoRepository.save(produto);
    }

}
