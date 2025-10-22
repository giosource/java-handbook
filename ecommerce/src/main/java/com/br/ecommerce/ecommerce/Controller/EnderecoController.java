package com.br.ecommerce.ecommerce.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.ecommerce.ecommerce.Entities.Endereco;
import com.br.ecommerce.ecommerce.Repositories.EnderecoRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    EnderecoRepository enderecoRepository;

    @PostMapping("/salvar")
    public String salvar(@RequestBody Endereco endereco) {
        enderecoRepository.save(endereco);
        return "Endereço cadastrado!";
    }

    @GetMapping("/listar")
    public List<Endereco> listar() {
        List<Endereco> enderecos = enderecoRepository.findAll();
        return enderecos;
    }

    @PutMapping("/editar/{idEndereco}")
    public String editar(@PathVariable int idEndereco, @RequestBody Endereco novoEndereco) {
        Endereco endereco = enderecoRepository.findById(idEndereco).get();
        endereco.setCep(novoEndereco.getCep());
        endereco.setNumero(novoEndereco.getNumero());
        endereco.setLogradouro(novoEndereco.getLogradouro());
        endereco.setUf(novoEndereco.getUf());

        enderecoRepository.save(endereco);
        return "Endereço editado!";
    }

    @DeleteMapping("/deletar/{idEndereco}")
    public String deletarPorId(@PathVariable int idEndereco) {
        if (enderecoRepository.existsById(idEndereco)) {
            enderecoRepository.deleteById(idEndereco);
            return "Endereço deletado!";
        } else {
            return "Endereço inexistente!";
        }
    }

}
