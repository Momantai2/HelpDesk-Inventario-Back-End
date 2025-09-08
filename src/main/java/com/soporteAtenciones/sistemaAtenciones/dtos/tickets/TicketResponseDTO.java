package com.soporteAtenciones.sistemaAtenciones.dtos.tickets;

import java.time.LocalDateTime;

import com.soporteAtenciones.sistemaAtenciones.models.Usuario;

import lombok.Data;


@Data
public class TicketResponseDTO {
    private Long idTicket;
    private String titulo;
    private String descripcion;
    private Long idEstado;
    private Long idPrioridad;
     private Usuario usuario;   // <-- Objeto completo

    private LocalDateTime fechaCreacion;
}