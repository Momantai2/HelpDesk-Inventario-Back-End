package com.soporteAtenciones.sistemaAtenciones.mappers;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.soporteAtenciones.sistemaAtenciones.dtos.tickets.TicketRequestDTO;
import com.soporteAtenciones.sistemaAtenciones.dtos.tickets.TicketResponseDTO;
import com.soporteAtenciones.sistemaAtenciones.models.Estado;
import com.soporteAtenciones.sistemaAtenciones.models.Prioridad;
import com.soporteAtenciones.sistemaAtenciones.models.Ticket;
import com.soporteAtenciones.sistemaAtenciones.models.Usuario;

@Mapper(componentModel = "spring")
public interface TicketMapper {

    // Mapeo de RequestDTO a Entity
    @Mapping(target = "estado", source = "idEstado")
    @Mapping(target = "usuario", source = "idUsuario") // mapUsuario se encargará de crear el objeto
    @Mapping(target = "prioridad", source = "idPrioridad")
    Ticket toEntity(TicketRequestDTO dto);

    // Mapeo de Entity a ResponseDTO
    @Mapping(target = "nombreEstado", source = "estado.nombre")
    @Mapping(target = "nombrePrioridad", source = "prioridad.nombre")
    @Mapping(target = "nombreUsuario", source = "usuario.nombre") // ahora todo el objeto Usuario
    TicketResponseDTO toResponseDto(Ticket ticket);

    default Estado mapEstado(Long idEstado) {
        if (idEstado == null) return null;
        Estado estado = new Estado();
        estado.setIdEstado(idEstado);
        return estado;
    }

    default Prioridad mapPrioridad(Long idPrioridad) {
        if (idPrioridad == null) return null;
        Prioridad prioridad = new Prioridad();
        prioridad.setIdPrioridad(idPrioridad);
        return prioridad;
    }

    default Usuario mapUsuario(Long idUsuario) {
        if (idUsuario == null) return null;
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(idUsuario);
        return usuario;
    }

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "estado", source = "idEstado")
    @Mapping(target = "usuario", source = "idUsuario") // mapUsuario se encargará de crear el objeto
    @Mapping(target = "prioridad", source = "idPrioridad")
    void updateEntityFromDto(TicketRequestDTO dto, @MappingTarget Ticket ticket);
}
