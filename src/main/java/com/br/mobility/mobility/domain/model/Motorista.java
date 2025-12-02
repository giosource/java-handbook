package com.br.mobility.mobility.domain.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Motorista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 9, nullable = false)
    private String cnh;

    @Column(unique = true, length = 11, nullable = false)
    private String cpf;

    @OneToMany
    @JoinColumn(name = "endereco")
    private Endereco endereco;

    @ManyToOne
    @JsonIgnore
    private List<Veiculo> veiculos;

    public Motorista() {
    }

    public Motorista(String cnh, String cpf, Endereco endereco, List<Veiculo> veiculos) {
        this.cnh = cnh;
        this.cpf = cpf;
        this.endereco = endereco;
        this.veiculos = veiculos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

}
