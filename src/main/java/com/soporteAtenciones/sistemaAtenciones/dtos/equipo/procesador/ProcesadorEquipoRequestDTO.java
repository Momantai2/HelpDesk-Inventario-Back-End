package com.soporteAtenciones.sistemaAtenciones.dtos.equipo.procesador;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProcesadorEquipoRequestDTO {
@NotBlank(message = "El nombre no puede estar vacío")
private String nombre;
  @NotNull(message = "El ID del Marca Procesador no puede ser nulo")
    private Long idMarcaProcesador;
      @NotNull(message = "El ID de la Generacion Procesador no puede ser nulo")
    private Long idGeneracionProcesador;
}
