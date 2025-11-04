package com.br.ecommerce.ecommerce.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.ecommerce.ecommerce.Dto.PedidoDto;
import com.br.ecommerce.ecommerce.Entities.Pedido;
import com.br.ecommerce.ecommerce.Entities.Produto;
import com.br.ecommerce.ecommerce.Repositories.PedidoRepository;
import com.br.ecommerce.ecommerce.Repositories.ProdutoRepository;
import com.br.ecommerce.ecommerce.Repositories.UsuarioRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @PostMapping("/salvar")
    public String salvar(@RequestBody PedidoDto pedidoDto) {

        List<Produto> produtos = new ArrayList<>();

        if (pedidoDto.getProdutosId() != null) {
            for (Integer produtoId : pedidoDto.getProdutosId()) {
                if (produtoRepository.findById(produtoId).isPresent()) {
                    produtos.add(produtoRepository.findById(produtoId).get());
                } else {
                    return "Produto inexistente!";
                }
            }
        } else {
            return "Sem produtos!";
        }

        Pedido pedido = new Pedido(pedidoDto.getLocalizacao(), pedidoDto.getValor(), pedidoDto.isCancelamento(),
                usuarioRepository.findById(pedidoDto.getUsuarioId()).get(), produtos);
        pedidoRepository.save(pedido);
        return "Pedido cadastrado!";
    }

    @GetMapping("/listar")
    public List<Pedido> listar() {
        List<Pedido> pedidos = pedidoRepository.findAll();
        return pedidos;
    }

    @PutMapping("/editar/{idPedido}")
    public String editar(@PathVariable int idPedido, @RequestBody Pedido novoPedido) {
        Pedido pedido = pedidoRepository.findById(idPedido).get();
        pedido.setLocalizacao(novoPedido.getLocalizacao());
        pedido.setValor(novoPedido.getValor());
        pedido.setCancelamento(novoPedido.isCancelamento());
        pedido.setUsuario(pedidoRepository.findById(idPedido).get().getUsuario());
        pedido.setProdutos(pedidoRepository.findById(idPedido).get().getProdutos());

        pedidoRepository.save(pedido);
        return "Pedido editado!";
    }

    @DeleteMapping("/deletar/{idPedido}")
    public String deletarPorId(@PathVariable int idPedido) {
        if (pedidoRepository.existsById(idPedido)) {
            pedidoRepository.deleteById(idPedido);
            return "Pedido deletado!";
        } else {
            return "Pedido inexistente!";
        }
    }

}
