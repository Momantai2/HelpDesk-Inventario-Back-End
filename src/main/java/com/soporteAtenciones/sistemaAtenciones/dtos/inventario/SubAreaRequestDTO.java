package com.soporteAtenciones.sistemaAtenciones.dtos.inventario;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SubAreaRequestDTO {

    @NotNull(message = "El ID del Tipo Sub Area no puede ser nulo")
    private Long idTipoSubArea;
    
    @NotNull(message = "El ID del Sucursal no puede ser nulo")
    private Long idSucursal;
}