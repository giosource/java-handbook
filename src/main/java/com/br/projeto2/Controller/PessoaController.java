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

import com.br.projeto2.Dto.PessoaDto;
import com.br.projeto2.Dto.PessoaLoginDto;
import com.br.projeto2.Entities.Pessoa;
import com.br.projeto2.Repositories.EnderecoRepository;
import com.br.projeto2.Repositories.PessoaRepository;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    PessoaRepository pessoaRepository;
    @Autowired
    EnderecoRepository enderecoRepository;

    @PostMapping("/salvar")
    public String salvar(@RequestBody PessoaDto pessoaDto) {

        if (pessoaRepository.findByEmail(pessoaDto.getEmail()).isPresent()) {
            return "E-mail já cadastrado!";
        }

        String hash = passwordEncoder.encode(pessoaDto.getSenha());
        pessoaDto.setSenha(hash);

        Pessoa pessoa = new Pessoa(pessoaDto.getNome(), pessoaDto.getEmail(), pessoaDto.getSenha(),
                enderecoRepository.findById(pessoaDto.getEnderecoId()).get());
        pessoaRepository.save(pessoa);

        return "Pessoa cadastrada!";
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
    public String deletarPorId(@PathVariable int idPessoa) {
        if (pessoaRepository.existsById(idPessoa)) {
            pessoaRepository.deleteById(idPessoa);
            return "Pessoa deletada!";
        } else {
            return "Pessoa não existe!";
        }
    }

    @PutMapping("/editar/{idPessoa}")
    public String editar(@PathVariable int idPessoa, @RequestBody Pessoa novaPessoa) {
        Pessoa pessoa = pessoaRepository.findById(idPessoa).get();
        pessoa.setNome(novaPessoa.getNome());
        pessoa.setEmail(novaPessoa.getEmail());
        pessoaRepository.save(pessoa);
        return "Pessoa editada!";
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
