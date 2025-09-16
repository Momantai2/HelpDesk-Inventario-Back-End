package com.soporteAtenciones.sistemaAtenciones.dtos.tickets;

import java.time.LocalDateTime;

import lombok.Data;


@Data
public class UsuarioResponseDTO {
    private Long idUsuario;
    private String nombre;
    private String email;
    private LocalDateTime fechaCreacion;
    private String nombrerol;
    private Long idRol;

}