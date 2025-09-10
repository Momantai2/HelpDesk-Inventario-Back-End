package com.soporteAtenciones.sistemaAtenciones.dtos.tickets;

import java.time.LocalDateTime;

import com.soporteAtenciones.sistemaAtenciones.models.Rol;

import lombok.Data;


@Data
public class UsuarioResponseDTO {
    private Long idUsuario;
    private String nombre;
    private String email;
     private Rol rol;   // <-- Objeto completo
    private LocalDateTime fechaCreacion;
    private String nombrerol;

}