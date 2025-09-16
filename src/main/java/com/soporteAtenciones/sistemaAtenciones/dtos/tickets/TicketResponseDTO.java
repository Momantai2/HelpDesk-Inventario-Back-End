package com.soporteAtenciones.sistemaAtenciones.dtos.tickets;

import java.time.LocalDateTime;

import lombok.Data;


@Data
public class TicketResponseDTO {
    private Long idTicket;
    private String titulo;
    private String descripcion;
   
private String nombrePrioridad;
private String nombreEstado;
private String nombreUsuario;
    private LocalDateTime fechaCreacion;
}