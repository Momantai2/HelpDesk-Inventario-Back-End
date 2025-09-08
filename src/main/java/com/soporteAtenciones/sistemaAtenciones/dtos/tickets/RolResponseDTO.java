package com.soporteAtenciones.sistemaAtenciones.dtos.tickets;

import java.time.LocalDateTime;

import lombok.Data;


@Data
public class RolResponseDTO {
    private Long idRol;
    private String nombre;
    private LocalDateTime fechaCreacion;
}