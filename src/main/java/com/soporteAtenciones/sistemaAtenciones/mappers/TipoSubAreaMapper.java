package com.soporteAtenciones.sistemaAtenciones.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.soporteAtenciones.sistemaAtenciones.dtos.inventario.TipoSubAreaRequest;
import com.soporteAtenciones.sistemaAtenciones.dtos.inventario.TipoSubAreaResponse;
import com.soporteAtenciones.sistemaAtenciones.models.inventario.Area;
import com.soporteAtenciones.sistemaAtenciones.models.inventario.TipoSubArea;

@Mapper(componentModel = "spring")
public interface TipoSubAreaMapper {

    @Mapping(target = "area", source = "idArea")
TipoSubArea toEntity(TipoSubAreaRequest dto);

    @Mapping(target = "area", source = "area")
    TipoSubAreaResponse toResponseDto(TipoSubArea area);

  default Area mapArea(Long idArea) {
        if (idArea == null) {
            return null;
        }
        Area area = new Area();
        area.setIdArea(idArea);
        return area;
    }

      // Para actualizar un Rol existente con los valores de un DTO
    @Mapping(target = "area", source = "idArea")
    @Mapping(target = "idTipoSubArea", ignore = true) // no queremos sobrescribir la PK
    void updateEntityFromDto(TipoSubAreaRequest dto, @MappingTarget TipoSubArea tipoSubArea);
}