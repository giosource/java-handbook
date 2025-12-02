package com.br.mobility.mobility.application.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.br.mobility.mobility.application.dto.DependenteCadastrarDto;
import com.br.mobility.mobility.application.dto.DependenteEditarDto;
import com.br.mobility.mobility.application.dto.DependenteListarDto;
import com.br.mobility.mobility.domain.model.Dependente;

@Mapper(componentModel = "spring")
public interface DependenteMapper {
    Dependente toEntity(DependenteCadastrarDto dependenteCadastrarDto);

    List<DependenteListarDto> toDtoListar(List<Dependente> dependente);

    void updateEntity(DependenteEditarDto dependenteEditarDto, @MappingTarget Dependente dependente);

}
