package com.soporteAtenciones.sistemaAtenciones.dtos.inventario;

import com.soporteAtenciones.sistemaAtenciones.models.inventario.Distrito;
import com.soporteAtenciones.sistemaAtenciones.models.inventario.TipoSucursal;

import lombok.Data;

@Data
public class SucursalResponseDTO {
    private Long idSucursal;
        private String nombre;
private TipoSucursal tiposucursal;
    private Distrito distrito;

}
