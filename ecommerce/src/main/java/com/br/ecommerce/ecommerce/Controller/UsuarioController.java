package com.br.ecommerce.ecommerce.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.ecommerce.ecommerce.Entities.Usuario;
import com.br.ecommerce.ecommerce.Repositories.UsuarioRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;
    
    @PostMapping("/salvar")
    public String salvar(@RequestBody Usuario usuario) {
        return "Pessoa cadastrada!";
    }
    
}
