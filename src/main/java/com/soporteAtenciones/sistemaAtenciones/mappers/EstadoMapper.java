package com.soporteAtenciones.sistemaAtenciones.mappers;

import com.soporteAtenciones.sistemaAtenciones.dtos.tickets.EstadoRequestDTO;
import com.soporteAtenciones.sistemaAtenciones.dtos.tickets.EstadoResponseDTO;
import com.soporteAtenciones.sistemaAtenciones.models.Estado;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EstadoMapper {


    Estado toEntity(EstadoRequestDTO dto);

    EstadoResponseDTO toResponseDto(Estado estado);

      // Para actualizar un Rol existente con los valores de un DTO
    @Mapping(target = "idEstado", ignore = true) // no queremos sobrescribir la PK
    @Mapping(target = "fechaCreacion", ignore = true) // tampoco la fecha de creación
    void updateEntityFromDto(EstadoRequestDTO dto, @MappingTarget Estado estado);
}