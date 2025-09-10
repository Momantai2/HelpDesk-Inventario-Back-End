package com.soporteAtenciones.sistemaAtenciones.dtos.tickets;

import java.time.LocalDateTime;

import com.soporteAtenciones.sistemaAtenciones.models.Estado;
import com.soporteAtenciones.sistemaAtenciones.models.Prioridad;
import com.soporteAtenciones.sistemaAtenciones.models.Usuario;

import lombok.Data;


@Data
public class TicketResponseDTO {
    private Long idTicket;
    private String titulo;
    private String descripcion;
     private Prioridad prioridad;   // <-- Objeto completo
     private Estado estado;   // <-- Objeto completo
     private Usuario usuario;   // <-- Objeto completo

    private LocalDateTime fechaCreacion;
}