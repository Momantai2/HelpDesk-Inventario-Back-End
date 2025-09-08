package com.soporteAtenciones.sistemaAtenciones.dtos.inventario;

import lombok.Data;


@Data
public class ProvinciaRequestDTO {
    private String nombre;
    private Long departamentoId; // el cliente solo manda el id del departamento
}