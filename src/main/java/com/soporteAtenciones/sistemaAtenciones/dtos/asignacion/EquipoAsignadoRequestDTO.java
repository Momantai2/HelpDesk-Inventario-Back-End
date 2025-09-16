package com.soporteAtenciones.sistemaAtenciones.dtos.asignacion;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EquipoAsignadoRequestDTO {

  @NotNull(message = "La fecha de último inventario es obligatoria")
    private LocalDateTime FechaDevolucion;
      @NotNull(message = "La fecha de último inventario es obligatoria")
    private LocalDateTime FechaAsignacion;
     @NotNull(message = "El  equipo es obligatorio")
    private Long idEquipo;
     @NotNull(message = "El Colaborador es obligatorio")
    private Long idColaborador;
}
