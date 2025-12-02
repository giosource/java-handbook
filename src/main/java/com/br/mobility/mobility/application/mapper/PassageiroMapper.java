package com.br.mobility.mobility.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.br.mobility.mobility.application.dto.PassageiroCadastrarDto;
import com.br.mobility.mobility.application.dto.PassageiroEditarDto;
import com.br.mobility.mobility.application.dto.PassageiroListarDto;
import com.br.mobility.mobility.domain.model.Passageiro;

@Mapper(componentModel = "spring")
public interface PassageiroMapper {
    Passageiro toEntity(PassageiroCadastrarDto passageiroCadastroDto);

    PassageiroListarDto toDtoListar(Passageiro passageiro);

    void updateEntity(PassageiroEditarDto passageiroEditarDto, @MappingTarget Passageiro passageiro);

}
