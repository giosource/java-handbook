package com.br.projeto2.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.projeto2.Entities.Pessoa;
import com.br.projeto2.Repositories.PessoaRepository;


@RestController
@RequestMapping("/pessoa")
public class PessoaController {
    @Autowired
    PessoaRepository pessoaRepository;

    @PostMapping("/salvar")
    public void salvar2(@RequestBody Pessoa pessoa) {
        pessoaRepository.save(pessoa);
    }

    @GetMapping("/listar")
    public void listar() {
        List<Pessoa> pessoas = pessoaRepository.findAll();
        for (Pessoa pessoa : pessoas) {
            System.out.println(
                "Nome:" + pessoa.getNome() + "\n" +
                "Email:" + pessoa.getEmail() + "\n"
            );
        }
    }
}
