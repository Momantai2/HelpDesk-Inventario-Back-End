package com.soporteAtenciones.sistemaAtenciones.dtos.inventario;

import com.soporteAtenciones.sistemaAtenciones.models.inventario.Sucursal;
import com.soporteAtenciones.sistemaAtenciones.models.inventario.TipoSubArea;

import lombok.Data;

@Data
public class SubAreaResponseDTO {

   private Long idSubArea;
    private TipoSubArea tipoSubArea;
    private Sucursal sucursal;
}