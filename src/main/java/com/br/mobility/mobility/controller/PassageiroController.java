package com.br.mobility.mobility.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.mobility.mobility.application.dto.DependenteCadastrarDto;
import com.br.mobility.mobility.application.dto.DependenteEditarDto;
import com.br.mobility.mobility.application.dto.DependenteListarDto;
import com.br.mobility.mobility.application.dto.PassageiroCadastrarDto;
import com.br.mobility.mobility.application.dto.PassageiroEditarDto;
import com.br.mobility.mobility.application.dto.PassageiroListarDto;
import com.br.mobility.mobility.domain.service.PassageiroService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/passageiro")
public class PassageiroController {

    private final PassageiroService passageiroService;

    public PassageiroController(PassageiroService passageiroService) {
        this.passageiroService = passageiroService;
    }

    @PostMapping("/cadastrar")
    public String cadastrarPassageiro(@RequestBody PassageiroCadastrarDto passageiroCadastrarDto) {
        passageiroService.cadastrarPassageiro(passageiroCadastrarDto);
        return "Passageiro cadastrado.";
    }

    @GetMapping("/listar")
    public PassageiroListarDto listarPassageiro(@AuthenticationPrincipal UserDetails userDetails) {
        String emailPassageiro = userDetails.getUsername();
        return passageiroService.listarPassageiro(emailPassageiro);
    }

    @PutMapping("/editar")
    public PassageiroEditarDto editarPassageiro(@AuthenticationPrincipal UserDetails userDetails,
            @RequestBody PassageiroEditarDto passageiroEditarDto) {
        String emailPassageiro = userDetails.getUsername();
        PassageiroEditarDto passageiro = passageiroService.editarPassageiro(emailPassageiro, passageiroEditarDto);
        return passageiro;
    }

    @PostMapping("/cadastrar/dependente")
    public String cadastrarDependente(@AuthenticationPrincipal UserDetails userDetails,
            @RequestBody DependenteCadastrarDto dependenteCadastrarDto) {
        String emailPassageiro = userDetails.getUsername();
        passageiroService.cadastrarDependente(emailPassageiro, dependenteCadastrarDto);
        return "Dependente cadastrado.";
    }

    @PostMapping("/listar/dependente")
    public List<DependenteListarDto> listarDependente(@AuthenticationPrincipal UserDetails userDetails) {
        String emailPassageiro = userDetails.getUsername();
        return passageiroService.listarDependente(emailPassageiro);
    }

    @PostMapping("/editar/dependente")
    public String editarDependente(@AuthenticationPrincipal UserDetails userDetails,
            @RequestBody DependenteEditarDto dependenteEditarDto) {
        String emailPassageiro = userDetails.getUsername();
        passageiroService.editarDependente(emailPassageiro, dependenteEditarDto);
        return "Dependente editado.";
    }

}
