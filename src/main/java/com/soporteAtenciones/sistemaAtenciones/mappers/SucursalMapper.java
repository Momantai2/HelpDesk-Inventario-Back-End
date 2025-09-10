package com.soporteAtenciones.sistemaAtenciones.mappers;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;


import com.soporteAtenciones.sistemaAtenciones.dtos.inventario.SucursalRequestDTO;
import com.soporteAtenciones.sistemaAtenciones.dtos.inventario.SucursalResponseDTO;
import com.soporteAtenciones.sistemaAtenciones.models.inventario.Distrito;
import com.soporteAtenciones.sistemaAtenciones.models.inventario.Sucursal;
import com.soporteAtenciones.sistemaAtenciones.models.inventario.TipoSucursal;

@Mapper(componentModel = "spring")
public interface SucursalMapper {

 @Mapping(target = "distrito", source = "idDistrito")
  @Mapping(target = "tiposucursal", source = "idTipoSucursal")
    Sucursal toEntity(SucursalRequestDTO dto);

    @Mapping(target = "distrito", source = "distrito")
        @Mapping(target = "tiposucursal", source = "tiposucursal")
    SucursalResponseDTO toResponseDto(Sucursal sucursal);

    default Distrito mapTicket(Long idDistrito) {
        if (idDistrito == null) {
            return null;
        }
        Distrito distrito = new Distrito();
        distrito.setIdDistrito(idDistrito);
        return distrito;
    }

    
    default TipoSucursal mapTipoSucursal(Long idTipoSucursal) {
        if (idTipoSucursal == null) {
            return null;
        }
        TipoSucursal tiposucursal = new TipoSucursal();
        tiposucursal.setIdTipoSucursal(idTipoSucursal);
        return tiposucursal;
    }


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "distrito", source = "idDistrito")
      @Mapping(target = "tiposucursal", source = "idTipoSucursal")
    void updateEntityFromDto(SucursalRequestDTO dto, @MappingTarget Sucursal sucursal);
}