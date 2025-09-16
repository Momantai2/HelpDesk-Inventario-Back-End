package com.soporteAtenciones.sistemaAtenciones.dtos.equipo.proovedor;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class LoteProovedorResponseDTO {
    private Long idLote;
    private String nombre;
    private LocalDateTime FechaIngresoRenting;
    private LocalDateTime FechVencimientoRenting;
    private String nombreProovedor;



}
