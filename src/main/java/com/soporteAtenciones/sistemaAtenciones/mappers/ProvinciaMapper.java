package com.soporteAtenciones.sistemaAtenciones.mappers;

import org.mapstruct.BeanMapping;

import com.soporteAtenciones.sistemaAtenciones.dtos.inventario.ProvinciaRequestDTO;
import com.soporteAtenciones.sistemaAtenciones.dtos.inventario.ProvinciaResponseDTO;
import com.soporteAtenciones.sistemaAtenciones.models.inventario.Provincia;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;


@Mapper(componentModel = "spring")
public interface ProvinciaMapper {

    Provincia toEntity(ProvinciaRequestDTO dto);

    ProvinciaResponseDTO toResponseDto(Provincia distrito);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(ProvinciaRequestDTO dto, @MappingTarget Provincia provincia);
}