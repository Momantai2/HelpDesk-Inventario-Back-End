package com.soporteAtenciones.sistemaAtenciones.mappers;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.soporteAtenciones.sistemaAtenciones.dtos.inventario.SubAreaRequestDTO;
import com.soporteAtenciones.sistemaAtenciones.dtos.inventario.SubAreaResponseDTO;
import com.soporteAtenciones.sistemaAtenciones.models.inventario.SubArea;
import com.soporteAtenciones.sistemaAtenciones.models.inventario.Sucursal;
import com.soporteAtenciones.sistemaAtenciones.models.inventario.TipoSubArea;

@Mapper(componentModel = "spring")
public interface SubAreaMapper {

    @Mapping(target = "sucursal", source = "idSucursal")
    @Mapping(target = "tipoSubArea", source = "idTipoSubArea")
    SubArea toEntity(SubAreaRequestDTO dto);

    @Mapping(target = "sucursal", source = "sucursal")
    @Mapping(target = "tipoSubArea", source = "tipoSubArea")
    SubAreaResponseDTO toResponseDto(SubArea subarea);


   
     default TipoSubArea mapTipoSubArea(Long idTipoSubArea) {
        if (idTipoSubArea == null) {
            return null;
        }
        TipoSubArea tipoSubArea = new TipoSubArea();
        tipoSubArea.setIdTipoSubArea(idTipoSubArea);
        return tipoSubArea;
    }

       default Sucursal mapSucursal(Long idSucursal) {
        if (idSucursal == null) {
            return null;
        }
        Sucursal sucursal = new Sucursal();
        sucursal.setIdSucursal(idSucursal);
        return sucursal;
    }

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "sucursal", source = "idSucursal")
    @Mapping(target = "tipoSubArea", source = "idTipoSubArea")
    void updateEntityFromDto(SubAreaRequestDTO dto, @MappingTarget SubArea subarea);
}