package com.soporteAtenciones.sistemaAtenciones.dtos.equipo;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ModeloEquipoRequestDTO {
@NotBlank(message = "El nombre no puede estar vacío")
private String nombre;
}
