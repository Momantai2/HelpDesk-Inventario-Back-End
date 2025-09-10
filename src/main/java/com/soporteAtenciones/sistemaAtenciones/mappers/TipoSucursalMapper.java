package com.soporteAtenciones.sistemaAtenciones.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.soporteAtenciones.sistemaAtenciones.dtos.inventario.TipoSucursalRequestDTO;
import com.soporteAtenciones.sistemaAtenciones.dtos.inventario.TipoSucursalResponseDTO;
import com.soporteAtenciones.sistemaAtenciones.models.inventario.TipoSucursal;

@Mapper(componentModel = "spring")
public interface TipoSucursalMapper {


    TipoSucursal toEntity(TipoSucursalRequestDTO dto);

    TipoSucursalResponseDTO toResponseDto(TipoSucursal tiposucursal);

      // Para actualizar un Rol existente con los valores de un DTO
    @Mapping(target = "idTipoSucursal", ignore = true) // no queremos sobrescribir la PK
    void updateEntityFromDto(TipoSucursalRequestDTO dto, @MappingTarget TipoSucursal tiposucursal);
}