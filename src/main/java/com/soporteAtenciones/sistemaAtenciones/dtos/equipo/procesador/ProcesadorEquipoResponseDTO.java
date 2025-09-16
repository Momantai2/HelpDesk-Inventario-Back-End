package com.soporteAtenciones.sistemaAtenciones.dtos.equipo.procesador;

import lombok.Data;

@Data
public class ProcesadorEquipoResponseDTO {
    private Long idProcesador;
    private String nombre;
    private String nombreMarcaProcesador;
    private String nombreGeneracionProcesador;

}
