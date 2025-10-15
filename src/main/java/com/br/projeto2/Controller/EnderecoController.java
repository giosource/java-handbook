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

import com.br.projeto2.Entities.Endereco;
import com.br.projeto2.Repositories.EnderecoRepository;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    EnderecoRepository enderecoRepository;

    @PostMapping("/salvar")
    public void salvar(@RequestBody Endereco endereco) {
        enderecoRepository.save(endereco);
    }

    @GetMapping("/listar")
    public void listar() {
        List<Endereco> enderecos = enderecoRepository.findAll();
        for (Endereco endereco : enderecos) {
            System.out.println(
                    "Rua:" + endereco.getRua() + "\n" +
                            "Cidade:" + endereco.getCidade() + "\n" +
                            "Estado:" + endereco.getEstado() + "\n" +
                            "CEP:" + endereco.getCep() + "\n" +
                            "Pais:" + endereco.getPais() + "\n");
        }
    }

    @DeleteMapping("/deletar/{idEndereco}")
    public void deletarPorId(@PathVariable int idEndereco) {
        if (enderecoRepository.existsById(idEndereco)) {
            enderecoRepository.deleteById(idEndereco);
        }
    }

    @PutMapping("/editar/{idEndereco}")
    public void editar(@PathVariable int idEndereco, @RequestBody Endereco novoEndereco) {
        Endereco endereco = enderecoRepository.findById(idEndereco).get();
        endereco.setRua(novoEndereco.getRua());
        endereco.setCidade(novoEndereco.getCidade());
        endereco.setEstado(novoEndereco.getEstado());
        endereco.setCep(novoEndereco.getCep());
        endereco.setPessoas(novoEndereco.getPessoas());

        enderecoRepository.save(endereco);
    }
}
