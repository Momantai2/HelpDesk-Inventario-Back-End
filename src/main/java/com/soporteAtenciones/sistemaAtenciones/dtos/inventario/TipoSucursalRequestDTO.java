package com.soporteAtenciones.sistemaAtenciones.dtos.inventario;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TipoSucursalRequestDTO {

    @NotBlank(message = "El texto no puede estar vacío")
private String nombre;

}
