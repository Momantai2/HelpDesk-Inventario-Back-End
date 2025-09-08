package com.soporteAtenciones.sistemaAtenciones.mappers;

import com.soporteAtenciones.sistemaAtenciones.dtos.inventario.ProvinciaRequestDTO;
import com.soporteAtenciones.sistemaAtenciones.dtos.inventario.ProvinciaResponseDTO;
import com.soporteAtenciones.sistemaAtenciones.models.inventario.Provincia;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProvinciaMapper {

    // De entidad a response
    @Mapping(source = "departamento.nombre", target = "departamentoNombre")
    ProvinciaResponseDTO toResponseDTO(Provincia entity);

    // De request a entidad (no se encarga del departamento)
    Provincia toEntity(ProvinciaRequestDTO dto);
}
