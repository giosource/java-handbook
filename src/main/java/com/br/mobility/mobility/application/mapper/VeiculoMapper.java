package com.br.mobility.mobility.application.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.br.mobility.mobility.application.dto.VeiculoCadastrarDto;
import com.br.mobility.mobility.application.dto.VeiculoEditarDto;
import com.br.mobility.mobility.application.dto.VeiculoListarDto;
import com.br.mobility.mobility.domain.model.Veiculo;

@Mapper(componentModel = "spring")
public interface VeiculoMapper {
  Veiculo toEntity(VeiculoCadastrarDto veiculoCadastrarDto);

  List<VeiculoListarDto> toDtoListar(List<Veiculo> veiculo);

  void updateEntity(VeiculoEditarDto veiculoEditarDto, @MappingTarget Veiculo veiculo);

}
