package com.br.mobility.mobility.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.br.mobility.mobility.application.dto.DependenteCadastrarDto;
import com.br.mobility.mobility.application.dto.DependenteEditarDto;
import com.br.mobility.mobility.application.dto.DependenteListarDto;
import com.br.mobility.mobility.application.dto.PassageiroCadastrarDto;
import com.br.mobility.mobility.application.dto.PassageiroEditarDto;
import com.br.mobility.mobility.application.dto.PassageiroListarDto;
import com.br.mobility.mobility.application.mapper.DependenteMapper;
import com.br.mobility.mobility.application.mapper.PassageiroMapper;
import com.br.mobility.mobility.domain.model.Dependente;
import com.br.mobility.mobility.domain.model.Passageiro;
import com.br.mobility.mobility.domain.repository.DependenteRepository;
import com.br.mobility.mobility.domain.repository.PassageiroRepository;
import com.br.mobility.mobility.exception.BusinessException;

@Service
public class PassageiroService {

    private final PassageiroRepository passageiroRepository;
    private final PassageiroMapper passageiroMapper;
    private final PasswordEncoder passwordEncoder;
    private final DependenteRepository dependenteRepository;
    private final DependenteMapper dependenteMapper;

    public PassageiroService(PassageiroRepository passageiroRepository, PassageiroMapper passageiroMapper,
            PasswordEncoder passwordEncoder, DependenteRepository dependenteRepository,
            DependenteMapper dependenteMapper) {
        this.passageiroRepository = passageiroRepository;
        this.passageiroMapper = passageiroMapper;
        this.passwordEncoder = passwordEncoder;
        this.dependenteRepository = dependenteRepository;
        this.dependenteMapper = dependenteMapper;
    }

    public Passageiro cadastrarPassageiro(PassageiroCadastrarDto passageiroCadastroDto) {

        Passageiro novoPassageiro = passageiroMapper.toEntity(passageiroCadastroDto);

        verificarTelefonePassageiro(novoPassageiro.getTelefone(), novoPassageiro.getId());
        verificarEmailPassageiro(novoPassageiro.getEmail(), novoPassageiro.getId());

        criptografarSenha(novoPassageiro);

        return passageiroRepository.save(novoPassageiro);
    }

    public PassageiroListarDto listarPassageiro(String email) {

        Passageiro passageiro = buscarPassageiroEmail(email);
        return passageiroMapper.toDtoListar(passageiro);
    }

    public PassageiroEditarDto editarPassageiro(String email, PassageiroEditarDto passageiroEditarDto) {
        Passageiro passageiro = buscarPassageiroEmail(email);

        passageiroMapper.updateEntity(passageiroEditarDto, passageiro);

        verificarTelefonePassageiro(passageiro.getTelefone(), passageiro.getId());
        verificarEmailPassageiro(passageiro.getEmail(), passageiro.getId());

        criptografarSenha(passageiro);
        passageiroRepository.save(passageiro);
        return passageiroEditarDto;
    }

    public Dependente cadastrarDependente(String email, DependenteCadastrarDto dependenteCadastrarDto) {

        Dependente novoDependente = dependenteMapper.toEntity(dependenteCadastrarDto);
        novoDependente.setPassageiro(passageiroRepository.findByEmail(email).get());
        return dependenteRepository.save(novoDependente);
    }

    public List<DependenteListarDto> listarDependente(String email) {
        return dependenteMapper
                .toDtoListar(dependenteRepository.findByPassageiro(passageiroRepository.findByEmail(email).get()));
    }

    public DependenteEditarDto editarDependente(String email, DependenteEditarDto dependenteEditarDto) {
        Dependente dependente = dependenteRepository.findById(dependenteEditarDto.getId()).get();
        dependenteMapper.updateEntity(dependenteEditarDto, dependente);
        dependenteRepository.save(dependente);
        return dependenteEditarDto;
    }

    private void verificarTelefonePassageiro(String telefone, Long id) {
        if (telefone == null) {
            throw new BusinessException("Telefone não existente.");
        }

        if (!telefone.matches("\\d{11}")) {
            throw new BusinessException("Telefone sem 11 digitos númericos.");
        }

        if (passageiroRepository.existsByTelefone(telefone) && passageiroRepository.findById(id).get().getId() != id) {
            throw new BusinessException("Telefone existente.");
        }
    }

    private void verificarEmailPassageiro(String email, Long id) {
        if (email == null) {
            throw new BusinessException("E-mail não existente.");
        }

        if (passageiroRepository.existsByEmail(email) && passageiroRepository.findById(id).get().getId() != id) {
            throw new BusinessException("E-mail existente.");
        }
    }

    private void criptografarSenha(Passageiro passageiro) {
        String senhaHash = passwordEncoder.encode(passageiro.getSenha());
        passageiro.setSenha(senhaHash);
    }

    private Passageiro buscarPassageiroEmail(String email) {
        Optional<Passageiro> passageiro = passageiroRepository.findByEmail(email);

        if (passageiro.isEmpty()) {
            throw new BusinessException("Passageiro não encontrado.");
        }

        return passageiro.get();
    }
}
