package com.soporteAtenciones.sistemaAtenciones.dtos.equipo.memoriaRam;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TipoMemoriaRamRequestDTO {
@NotBlank(message = "El nombre no puede estar vacío")
private String nombre;
}
