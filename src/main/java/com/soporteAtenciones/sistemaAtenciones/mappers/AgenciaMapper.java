package com.soporteAtenciones.sistemaAtenciones.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.soporteAtenciones.sistemaAtenciones.dtos.inventario.AgenciaRequestDTO;
import com.soporteAtenciones.sistemaAtenciones.dtos.inventario.AgenciaResponseDTO;
import com.soporteAtenciones.sistemaAtenciones.models.inventario.Agencia;

@Mapper(componentModel = "spring")
public interface AgenciaMapper {


    Agencia toEntity(AgenciaRequestDTO dto);

    AgenciaResponseDTO toResponseDto(Agencia agencia);

      // Para actualizar un Rol existente con los valores de un DTO
    @Mapping(target = "idAgencia", ignore = true) // no queremos sobrescribir la PK
    void updateEntityFromDto(AgenciaRequestDTO dto, @MappingTarget Agencia agencia);
}