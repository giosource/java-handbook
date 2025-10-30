package com.br.ecommerce.ecommerce.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.ecommerce.ecommerce.Dto.UsuarioDto;
import com.br.ecommerce.ecommerce.Entities.Usuario;
import com.br.ecommerce.ecommerce.Repositories.EnderecoRepository;
import com.br.ecommerce.ecommerce.Repositories.PedidoRepository;
import com.br.ecommerce.ecommerce.Repositories.UsuarioRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UsuarioRepository usuarioRepository;


    @Autowired
    EnderecoRepository enderecoRepository;

    @Autowired
    PedidoRepository pedidoRepository;

    @PostMapping("/salvar")
    public String salvar(@RequestBody UsuarioDto usuarioDto) {
        if (usuarioRepository.findByEmail(usuarioDto.getEmail()).isPresent()) {
            return "E-mail existente!";
        }

        String hash = passwordEncoder.encode(usuarioDto.getSenha());
        usuarioDto.setSenha(hash);
        Usuario usuario = new Usuario(usuarioDto.getNome(), usuarioDto.getCpf(), usuarioDto.getTelefone(), usuarioDto.getEmail(), usuarioDto.getSenha(), enderecoRepository.findById(usuarioDto.getEnderecoId()).get(), pedidoRepository.findById(usuarioDto.getPedidoId()).get());
        usuarioRepository.save(usuario);
        return "Usuário cadastrado!";
    }

    @GetMapping("/listar")
    public List<Usuario> listar() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios;
    }

    @PutMapping("/editar/{idUsuario}")
    public String editar(@PathVariable int idUsuario, @RequestBody Usuario novoUsuario) {
        Usuario usuario = usuarioRepository.findById(idUsuario).get();

        usuario.setNome(novoUsuario.getNome());
        usuario.setCpf(novoUsuario.getCpf());
        usuario.setTelefone(novoUsuario.getTelefone());
        usuario.setEmail(novoUsuario.getEmail());

        usuarioRepository.save(usuario);
        return "Usuário editado!";
    }

    @DeleteMapping("/deletar/{idUsuario}")
    public String deletarPorId(@PathVariable int idUsuario) {
        if (usuarioRepository.existsById(idUsuario)) {
            usuarioRepository.deleteById(idUsuario);
            return "Usuário deletado!";
        } else {
            return "Usuário inexistente!";
        }
    }

}
