package com.soporteAtenciones.sistemaAtenciones.dtos.tickets;

import java.time.LocalDateTime;

import lombok.Data;


@Data
public class PrioridadResponseDTO {
    private Long idPrioridad;
    private String nombre;
    private LocalDateTime fechaCreacion;
}