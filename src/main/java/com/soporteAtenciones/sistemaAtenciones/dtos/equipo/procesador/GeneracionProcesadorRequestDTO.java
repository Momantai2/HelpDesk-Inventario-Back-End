package com.soporteAtenciones.sistemaAtenciones.dtos.equipo.procesador;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
class GeneracionProcesadorRequestDTO {
@NotBlank(message = "El nombre no puede estar vacío")
private String nombre;
}
