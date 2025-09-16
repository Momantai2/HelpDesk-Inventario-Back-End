package com.soporteAtenciones.sistemaAtenciones.dtos.asignacion;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ColaboradorRequestDTO {
@NotBlank(message = "El nombre no puede estar vacío")
private String nombres;
@NotBlank(message = "El apellido no puede estar vacío")
private String apellidos;

  @NotNull(message = "El ID del SubArea no puede ser nulo")
    private Long idSubArea;
}
