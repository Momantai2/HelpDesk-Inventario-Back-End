package com.soporteAtenciones.sistemaAtenciones.dtos.equipo.almacenamiento;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TipoAlmacenamientoRequestDTO {
@NotBlank(message = "El nombre no puede estar vacío")
private String nombre;
    
}


