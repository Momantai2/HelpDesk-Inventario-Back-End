package com.soporteAtenciones.sistemaAtenciones.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import com.soporteAtenciones.sistemaAtenciones.models.Rol;
import com.soporteAtenciones.sistemaAtenciones.dtos.tickets.RolRequestDTO;
import com.soporteAtenciones.sistemaAtenciones.dtos.tickets.RolResponseDTO;

@Mapper(componentModel = "spring")
public interface RolMapper {

    // DTO -> Entity
    Rol toEntity(RolRequestDTO dto);

    // Entity -> DTO
    RolResponseDTO toResponseDto(Rol rol);

     // Para actualizar un Rol existente con los valores de un DTO
    @Mapping(target = "idRol", ignore = true) // no queremos sobrescribir la PK
    @Mapping(target = "fechaCreacion", ignore = true) // tampoco la fecha de creación
    void updateEntityFromDto(RolRequestDTO dto, @MappingTarget Rol rol);
}
