package com.soporteAtenciones.sistemaAtenciones.mappers;

import com.soporteAtenciones.sistemaAtenciones.dtos.tickets.UsuarioRequestDTO;
import com.soporteAtenciones.sistemaAtenciones.dtos.tickets.UsuarioResponseDTO;
import com.soporteAtenciones.sistemaAtenciones.models.Usuario;
import com.soporteAtenciones.sistemaAtenciones.models.Rol;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;


@Mapper(componentModel = "spring")
public interface UsuarioMapper {


    @Mapping(target = "rol", source = "idRol")
    Usuario toEntity(UsuarioRequestDTO dto);

    @Mapping(target = "nombrerol", source = "rol.nombre")
    @Mapping(target = "idRol", source = "rol.idRol")
    UsuarioResponseDTO toResponseDto(Usuario usuario);

    default Rol mapTicket(Long idRol) {
        if (idRol == null) {
            return null;
        }
        Rol rol = new Rol();
        rol.setIdRol(idRol);
        return rol;
    }

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "rol", source = "idRol")
    void updateEntityFromDto(UsuarioRequestDTO dto, @MappingTarget Usuario usuario);
}