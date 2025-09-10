package com.soporteAtenciones.sistemaAtenciones.mappers;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.soporteAtenciones.sistemaAtenciones.dtos.inventario.DistritoRequestDTO;
import com.soporteAtenciones.sistemaAtenciones.dtos.inventario.DistritoResponseDTO;
import com.soporteAtenciones.sistemaAtenciones.models.inventario.Distrito;
import com.soporteAtenciones.sistemaAtenciones.models.inventario.Provincia;

@Mapper(componentModel = "spring")
public interface DistritoMapper {
  @Mapping(target = "provincia", source = "idProvincia")
    Distrito toEntity(DistritoRequestDTO dto);

    @Mapping(target = "provincia", source = "provincia")
    DistritoResponseDTO toResponseDto(Distrito distrito);

    default Provincia mapTicket(Long idProvincia) {
        if (idProvincia == null) {
            return null;
        }
        Provincia provincia = new Provincia();
        provincia.setIdProvincia(idProvincia);
        return provincia;
    }

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "provincia", source = "idProvincia")
    void updateEntityFromDto(DistritoRequestDTO dto, @MappingTarget Distrito distrito);
}