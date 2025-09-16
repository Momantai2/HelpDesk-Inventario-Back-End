package com.soporteAtenciones.sistemaAtenciones.dtos.equipo;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EquipoRequestDTO {
   @NotBlank(message = "El número de serie es obligatorio")
    private String nroSerie;

    private Long idAlmacenamiento;

    private Long idMemoriaRam;

    private Long idProcesador;

    @NotNull(message = "El estado del equipo es obligatorio")
    private Long idEstadoEquipo;

    @NotNull(message = "La marca del equipo es obligatoria")
    private Long idMarcaEquipo;

    @NotNull(message = "El modelo del equipo es obligatorio")
    private Long idModeloEquipo;

    @NotNull(message = "El tipo de equipo es obligatorio")
    private Long idTipoEquipo;

    private Long idLoteProovedor;

    @NotNull(message = "La fecha de último inventario es obligatoria")
    private LocalDateTime fechaUltimoInventario;

    private String observacion;
}
