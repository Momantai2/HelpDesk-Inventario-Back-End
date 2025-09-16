package com.soporteAtenciones.sistemaAtenciones.dtos.equipo.almacenamiento;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AlmacenamientoEquipoRequestDTO {

@NotBlank(message = "El nombre no puede estar vacío")
private String nombre;

  @NotNull(message = "El ID del Tipo Almacenamiento no puede ser nulo")
    private Long idTipoAlmacenamiento;

}
 