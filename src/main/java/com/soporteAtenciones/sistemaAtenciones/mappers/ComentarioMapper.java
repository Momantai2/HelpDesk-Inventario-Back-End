package com.soporteAtenciones.sistemaAtenciones.mappers;


import com.soporteAtenciones.sistemaAtenciones.models.Comentario;
import com.soporteAtenciones.sistemaAtenciones.models.Ticket;
import com.soporteAtenciones.sistemaAtenciones.models.Usuario;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.soporteAtenciones.sistemaAtenciones.dtos.tickets.ComentarioRequestDTO;
import com.soporteAtenciones.sistemaAtenciones.dtos.tickets.ComentarioResponseDTO;

@Mapper(componentModel = "spring")
public interface ComentarioMapper {


    @Mapping(target = "ticket", source = "idTicket")
    @Mapping(target = "usuario", source = "idUsuario")
    Comentario toEntity(ComentarioRequestDTO dto);

    @Mapping(target = "idTicket", source = "ticket.idTicket")
    @Mapping(target = "idUsuario", source = "usuario.idUsuario")
    ComentarioResponseDTO toResponseDto(Comentario comentario);

    default Ticket mapTicket(Long idTicket) {
        if (idTicket == null) {
            return null;
        }
        Ticket ticket = new Ticket();
        ticket.setIdTicket(idTicket);
        return ticket;
    }

    default Usuario mapUsuario(Long idUsuario) {
        if (idUsuario == null) {
            return null;
        }
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(idUsuario);
        return usuario;
    }
}