package com.soporteAtenciones.sistemaAtenciones.dtos.tickets;

import java.time.LocalDateTime;

import lombok.Data;


@Data
public class ComentarioResponseDTO {
    private Long idComentario;
    private String texto;
    private Long idTicket;
    private Long idUsuario;
    private LocalDateTime fechaCreacion;
}