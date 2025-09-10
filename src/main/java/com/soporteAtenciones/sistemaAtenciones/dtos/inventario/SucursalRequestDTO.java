package com.soporteAtenciones.sistemaAtenciones.dtos.inventario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SucursalRequestDTO {

@NotBlank(message = "El texto no puede estar vacío")
    private String nombre;
    
@NotNull(message = "El ID del Tipo Sucursal no puede ser nulo")
    private Long idTipoSucursal;
@NotNull(message = "El ID del Distrito no puede ser nulo")
    private Long idDistrito;
}