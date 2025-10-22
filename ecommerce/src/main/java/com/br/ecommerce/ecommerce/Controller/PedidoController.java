package com.br.ecommerce.ecommerce.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.ecommerce.ecommerce.Entities.Pedido;
import com.br.ecommerce.ecommerce.Repositories.PedidoRepository;
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

    @PostMapping("/salvar")
    public String salvar(@RequestBody Pedido pedido) {
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
