package com.soporteAtenciones.sistemaAtenciones.dtos.inventario;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AreaRequestDTO {

@NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;
    
}
