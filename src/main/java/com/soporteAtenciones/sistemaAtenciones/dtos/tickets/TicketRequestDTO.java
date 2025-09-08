package com.soporteAtenciones.sistemaAtenciones.dtos.tickets;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TicketRequestDTO {
    @NotBlank(message = "El título no puede estar vacío")
    private String titulo;

    @NotBlank(message = "La descripción no puede estar vacía")
    private String descripcion;

    @NotNull(message = "El ID de estado no puede ser nulo")
    private Long idEstado;

    @NotNull(message = "El ID de prioridad no puede ser nulo")
    private Long idPrioridad;

    @NotNull(message = "El ID de usuario no puede ser nulo")
    private Long idUsuario;
}