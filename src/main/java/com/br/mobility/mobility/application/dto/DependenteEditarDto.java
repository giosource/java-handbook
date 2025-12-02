package com.br.mobility.mobility.application.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class DependenteEditarDto {

    @NotBlank
    private Long id;

    @NotBlank
    @Pattern(regexp = "^[A-Za-z]{2,}\\s[A-Za-z]{2,}+$*")
    @Column(nullable = false, length = 100)
    @Size(min = 2, max = 100)
    private String nome;

    public DependenteEditarDto() {
    }

    public DependenteEditarDto(@NotBlank Long id,
            @NotBlank @Pattern(regexp = "^[A-Za-z]{2,}\\s[A-Za-z]{2,}+$*") @Size(min = 2, max = 100) String nome) {
        this.id = id;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
