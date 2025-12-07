package com.br.mobility.mobility.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.br.mobility.mobility.application.dto.EnderecoCadastrarDto;
import com.br.mobility.mobility.application.dto.EnderecoEditarDto;
import com.br.mobility.mobility.application.dto.EnderecoListarDto;
import com.br.mobility.mobility.domain.model.Endereco;

@Mapper(componentModel = "spring")
public interface EnderecoMapper {
  Endereco toEntity(EnderecoCadastrarDto enderecoCadastrarDto);

  EnderecoListarDto toDtoListar(Endereco endereco);

  void updateEntity(EnderecoEditarDto enderecoEditarDto, @MappingTarget Endereco endereco);

}
