package com.soporteAtenciones.sistemaAtenciones.mappers;

import com.soporteAtenciones.sistemaAtenciones.dtos.tickets.PrioridadRequestDTO;
import com.soporteAtenciones.sistemaAtenciones.dtos.tickets.PrioridadResponseDTO;
import com.soporteAtenciones.sistemaAtenciones.dtos.tickets.RolRequestDTO;
import com.soporteAtenciones.sistemaAtenciones.models.Prioridad;
import com.soporteAtenciones.sistemaAtenciones.models.Rol;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PrioridadMapper {


    Prioridad toEntity(PrioridadRequestDTO dto);

    PrioridadResponseDTO toResponseDto(Prioridad prioridad);
      // Para actualizar un Rol existente con los valores de un DTO
    @Mapping(target = "idPrioridad", ignore = true) // no queremos sobrescribir la PK
    @Mapping(target = "fechaCreacion", ignore = true) // tampoco la fecha de creación
    void updateEntityFromDto(PrioridadRequestDTO dto, @MappingTarget Prioridad prioridad);
}