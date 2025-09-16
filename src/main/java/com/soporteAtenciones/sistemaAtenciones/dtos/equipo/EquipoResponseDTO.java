package com.soporteAtenciones.sistemaAtenciones.dtos.equipo;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class EquipoResponseDTO {
    private Long idEquipo;
    private String nroSerie;
    private LocalDateTime FechaUltimoInventario;
    private String Observacion;
    private String nombreAlmacenamientoEquipo;
    private String nombreMemoriaRamEquipo;
    private String nombreProcesadorEquipo;
    private String nombreEstadoEquipo;
    private String nombreMarcaEquipo;
    private String nombreModeloEquipo;
    private String nombreTipoEquipo;
    private String nombreLote;

}
