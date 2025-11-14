package com.br.ecommerce.ecommerce.Controller;

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

import com.br.ecommerce.ecommerce.Dto.ItemDto;
import com.br.ecommerce.ecommerce.Entities.Item;
import com.br.ecommerce.ecommerce.Repositories.ItemRepository;
import com.br.ecommerce.ecommerce.Repositories.PedidoRepository;
import com.br.ecommerce.ecommerce.Repositories.ProdutoRepository;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    ProdutoRepository produtoRepository;

    @PostMapping("/salvar")
    public String salvar(@RequestBody ItemDto itemDto) {

        Item item = new Item(produtoRepository.findById(itemDto.getProdutoId()).get(),
                pedidoRepository.findById(itemDto.getPedidoId()).get());

        itemRepository.save(item);
        return "Item cadastrado!";
    }

    @GetMapping("/listar")
    public List<Item> listar() {
        List<Item> itens = itemRepository.findAll();
        return itens;
    }

    @PutMapping("/editar/{idItem}/{idProduto}/{idPedido}")
    public String editar(@PathVariable int idItem, @PathVariable int idProduto, @PathVariable int idPedido,
            @RequestBody Item novoItem) {
        Item item = itemRepository.findById(idItem).get();
        item.setProduto(produtoRepository.findById(idProduto).get());
        item.setPedido(pedidoRepository.findById(idPedido).get());

        itemRepository.save(item);
        return "Item editado!";
    }

    @DeleteMapping("/deletar/{idItem}")
    public String deletarPorId(@PathVariable int idItem) {
        if (itemRepository.existsById(idItem)) {
            itemRepository.deleteById(idItem);
            return "Item deletado!";
        } else {
            return "Item inexistente!";
        }
    }

}
