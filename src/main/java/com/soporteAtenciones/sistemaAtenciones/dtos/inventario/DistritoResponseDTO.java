package com.soporteAtenciones.sistemaAtenciones.dtos.inventario;

import com.soporteAtenciones.sistemaAtenciones.models.inventario.Provincia;

import lombok.Data;

@Data
public class DistritoResponseDTO {

  private Long idDistrito;
private String nombre;
private Provincia provincia;   // <-- Objeto completo
}