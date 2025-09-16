package com.soporteAtenciones.sistemaAtenciones.dtos.equipo.proovedor;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProovedorRentingRequestDTO {
@NotBlank(message = "El nombre no puede estar vacío")
private String nombre;
}
