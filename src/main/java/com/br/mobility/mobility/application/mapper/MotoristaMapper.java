package com.br.mobility.mobility.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.br.mobility.mobility.application.dto.MotoristaCadastrarDto;
import com.br.mobility.mobility.application.dto.MotoristaEditarDto;
import com.br.mobility.mobility.application.dto.MotoristaListarDto;
import com.br.mobility.mobility.domain.model.Motorista;

@Mapper(componentModel = "spring")
public interface MotoristaMapper {
  Motorista toEntity(MotoristaCadastrarDto motoristaCadastrarDto);

  MotoristaListarDto toDtoListar(Motorista motorista);

  void updateEntity(MotoristaEditarDto motoristaEditarDto, @MappingTarget Motorista motorista);

}
