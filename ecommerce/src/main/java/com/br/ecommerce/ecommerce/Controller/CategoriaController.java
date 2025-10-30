package com.br.ecommerce.ecommerce.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.ecommerce.ecommerce.Dto.CategoriaDto;
import com.br.ecommerce.ecommerce.Entities.Categoria;
import com.br.ecommerce.ecommerce.Entities.Produto;
import com.br.ecommerce.ecommerce.Repositories.CategoriaRepository;
import com.br.ecommerce.ecommerce.Repositories.ProdutoRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    ProdutoRepository produtoRepository;

    @PostMapping("/salvar")
    public String salvar(@RequestBody CategoriaDto categoriaDto) {

        List<Produto> produtos = new ArrayList<>();

        if (categoriaDto.getProdutosId() != null) {
            for (Integer produtoId : categoriaDto.getProdutosId()) {
                if (produtoRepository.findById(produtoId).isPresent()) {
                    produtos.add(produtoRepository.findById(produtoId).get());
                } else {
                    return "Produto inexistente!";
                }
            }
        } else {
            return "Sem produtos!";
        }

        Categoria categoria = new Categoria(categoriaDto.getNome(), produtos);

        categoriaRepository.save(categoria);
        return "Categoria cadastrada!";
    }

    @GetMapping("/listar")
    public List<Categoria> listar() {
        List<Categoria> categorias = categoriaRepository.findAll();
        return categorias;
    }

    @PutMapping("/editar/{idCategoria}")
    public String editar(@PathVariable int idCategoria, @RequestBody Categoria novoCategoria) {
        Categoria categoria = categoriaRepository.findById(idCategoria).get();
        categoria.setNome(novoCategoria.getNome());

        categoriaRepository.save(categoria);
        return "Categoria editada!";
    }

    @DeleteMapping("/deletar/{idCategoria}")
    public String deletarPorId(@PathVariable int idCategoria) {
        if (categoriaRepository.existsById(idCategoria)) {
            categoriaRepository.deleteById(idCategoria);
            return "Categoria deletada!";
        } else {
            return "Categoria inexistente!";
        }
    }

}
