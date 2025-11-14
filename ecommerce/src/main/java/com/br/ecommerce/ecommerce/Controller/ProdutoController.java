package com.br.ecommerce.ecommerce.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.ecommerce.ecommerce.Dto.ProdutoDto;
import com.br.ecommerce.ecommerce.Entities.Item;
import com.br.ecommerce.ecommerce.Entities.Produto;
import com.br.ecommerce.ecommerce.Repositories.CategoriaRepository;
import com.br.ecommerce.ecommerce.Repositories.ItemRepository;
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
    ItemRepository itemRepository;

    @PostMapping("/salvar")
    public String salvar(@RequestBody ProdutoDto produtoDto) {

        List<Item> itens = new ArrayList<>();

        if (produtoDto.getItensId() != null) {
            for (Integer itemId : produtoDto.getItensId()) {
                if (itemRepository.findById(itemId).isPresent()) {
                    itens.add(itemRepository.findById(itemId).get());
                } else {
                    return "Item inexistente!";
                }
            }
        } else {
            return "Sem itens!";
        }

        Produto produto = new Produto(produtoDto.getNome(), produtoDto.getEspecificacao(), produtoDto.getPreco(),
                produtoDto.getEstoque(), produtoDto.isDisponibilidade(),
                categoriaRepository.findById(produtoDto.getCategoriaId()).get(), itens);
        produtoRepository.save(produto);
        return "Produto cadastrado!";
    }

    @GetMapping("/listar")
    public List<Produto> listar() {
        List<Produto> produtos = produtoRepository.findAll();
        return produtos;
    }

    @PutMapping("/editar/{idProduto}")
    public String editar(@PathVariable int idProduto,
            @RequestBody Produto novoProduto) {
        Produto produto = produtoRepository.findById(idProduto).get();
        produto.setNome(novoProduto.getNome());
        produto.setEspecificacao(novoProduto.getEspecificacao());
        produto.setPreco(novoProduto.getPreco());
        produto.setEstoque(novoProduto.getEstoque());
        produto.setDisponibilidade(novoProduto.isDisponibilidade());
        produto.setCategoria(produtoRepository.findById(idProduto).get().getCategoria());
        produtoRepository.save(produto);
        produto.setItens(produtoRepository.findById(idProduto).get().getItens());
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
