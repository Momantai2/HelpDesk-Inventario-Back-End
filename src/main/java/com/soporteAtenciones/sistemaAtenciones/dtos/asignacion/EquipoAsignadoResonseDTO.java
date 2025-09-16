package com.soporteAtenciones.sistemaAtenciones.dtos.asignacion;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class EquipoAsignadoResonseDTO {
    private Long idEquipoAsignado;
    private LocalDateTime FechaAsignacion;
    private LocalDateTime FechaDevolucion;
    private String nombreColaborador;
    private String nombreEquipo;

}
