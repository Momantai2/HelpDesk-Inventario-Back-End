package com.soporteAtenciones.sistemaAtenciones.dtos.inventario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TipoSubAreaRequest {
@NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;
    
    @NotNull(message = "El ID del Area no puede ser nulo")
    private Long idArea;
}
