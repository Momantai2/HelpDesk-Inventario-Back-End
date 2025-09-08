package com.soporteAtenciones.sistemaAtenciones.dtos.tickets;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ComentarioRequestDTO {
    @NotBlank(message = "El texto no puede estar vacío")
    private String texto;

    @NotNull(message = "El ID del ticket no puede ser nulo")
    private Long idTicket;

    @NotNull(message = "El ID del usuario no puede ser nulo")
    private Long idUsuario;
}