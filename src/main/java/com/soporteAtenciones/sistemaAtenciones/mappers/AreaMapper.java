package com.soporteAtenciones.sistemaAtenciones.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.soporteAtenciones.sistemaAtenciones.dtos.inventario.AreaRequestDTO;
import com.soporteAtenciones.sistemaAtenciones.dtos.inventario.AreaResponseDTO;
import com.soporteAtenciones.sistemaAtenciones.models.inventario.Area;

@Mapper(componentModel = "spring")
public interface AreaMapper {

 Area toEntity(AreaRequestDTO dto);

    AreaResponseDTO toResponseDto(Area area);

      // Para actualizar un Rol existente con los valores de un DTO
    @Mapping(target = "idArea", ignore = true) // no queremos sobrescribir la PK
    void updateEntityFromDto(AreaRequestDTO dto, @MappingTarget Area area);
}