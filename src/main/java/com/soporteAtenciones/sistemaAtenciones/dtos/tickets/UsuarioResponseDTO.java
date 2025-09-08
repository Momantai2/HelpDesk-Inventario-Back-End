package com.soporteAtenciones.sistemaAtenciones.dtos.tickets;

import java.time.LocalDateTime;

import lombok.Data;


@Data
public class UsuarioResponseDTO {
    private Long idUsuario;
    private String nombre;
    private String email;
    private Long idRol;
    private LocalDateTime fechaCreacion;
}