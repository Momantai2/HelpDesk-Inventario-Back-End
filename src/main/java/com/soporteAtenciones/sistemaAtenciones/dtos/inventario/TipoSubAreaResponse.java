package com.soporteAtenciones.sistemaAtenciones.dtos.inventario;

import com.soporteAtenciones.sistemaAtenciones.models.inventario.Area;

import lombok.Data;

@Data
public class TipoSubAreaResponse {

 private Long idTipoSubArea;
    private String nombre;
        private Area area;   // <-- Objeto completo

}
