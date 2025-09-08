package com.soporteAtenciones.sistemaAtenciones.dtos.tickets;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RolRequestDTO {
    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;
}