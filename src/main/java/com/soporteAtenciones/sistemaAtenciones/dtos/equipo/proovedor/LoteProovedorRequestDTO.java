package com.soporteAtenciones.sistemaAtenciones.dtos.equipo.proovedor;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LoteProovedorRequestDTO {
@NotBlank(message = "El nombre no puede estar vacío")
private String nombre;
@NotBlank(message = "La fecha de ingreso del renting no puede estar vacío")
private LocalDateTime FechaIngresoRenting;
@NotBlank(message = "La fecha de ingreso del renting no puede estar vacío")
private LocalDateTime FechVencimientoRenting;
@NotNull(message = "El ID del Proovedor no puede ser nulo")
private Long idProovedor;
   
}
