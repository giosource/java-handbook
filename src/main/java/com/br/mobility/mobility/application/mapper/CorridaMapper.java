package com.br.mobility.mobility.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.br.mobility.mobility.application.dto.CorridaCadastrarDto;
import com.br.mobility.mobility.application.dto.CorridaEditarDto;
import com.br.mobility.mobility.domain.model.Corrida;

@Mapper(componentModel = "spring")
public interface CorridaMapper {
  Corrida toEntity(CorridaCadastrarDto corridaCadastrarDto);

  void updateEntity(CorridaEditarDto corridaEditarDto, @MappingTarget Corrida corrida);

}
