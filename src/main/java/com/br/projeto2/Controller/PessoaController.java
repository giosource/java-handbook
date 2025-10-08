package com.br.projeto2.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.projeto2.Dto.PessoaLoginDto;
import com.br.projeto2.Entities.Pessoa;
import com.br.projeto2.Repositories.PessoaRepository;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    private final PasswordEncoder passwordEncoder;
    @Autowired
    PessoaRepository pessoaRepository;

    PessoaController(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/salvar")
    public void salvar(@RequestBody Pessoa pessoa) {
        String senhaCrypt = passwordEncoder.encode(pessoa.getSenha());
        pessoa.setSenha(senhaCrypt);
        pessoaRepository.save(pessoa);
    }

    @GetMapping("/listar")
    public void listar() {
        List<Pessoa> pessoas = pessoaRepository.findAll();
        for (Pessoa pessoa : pessoas) {
            System.out.println(
                    "Nome:" + pessoa.getNome() + "\n" +
                    "Email:" + pessoa.getEmail() + "\n");
        }
    }

    @DeleteMapping("/deletar/{idPessoa}")
    public void deletarPorId(@PathVariable int idPessoa) {
        if (pessoaRepository.existsById(idPessoa)) {
            pessoaRepository.deleteById(idPessoa);
        }
    }

    @PutMapping("/editar/{idPessoa}")
    public void editar(@PathVariable int idPessoa, @RequestBody Pessoa novaPessoa) {
        Pessoa pessoa = pessoaRepository.findById(idPessoa).get();
        pessoa.setNome(novaPessoa.getNome());
        pessoa.setEmail(novaPessoa.getEmail());
        pessoaRepository.save(pessoa);
    }

    @PostMapping("/login")
    public String login(@RequestBody PessoaLoginDto pessoaLoginDto) {
        Pessoa pessoa = pessoaRepository.findByEmail(pessoaLoginDto.getEmail()).get();
        if (pessoa != null) {
            if (passwordEncoder.matches(pessoaLoginDto.getSenha(), pessoa.getSenha())) {
                return "Login com sucesso!";
            } else {
                return "Senha incorreta!";
            }
        } else {
            return "Email não cadastrado!";
        }      
    }
    
}
