package com.soporteAtenciones.sistemaAtenciones.models.inventario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="tipoSucursal")
@Data
public class TipoSucursal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipoSucursal;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String nombre;

  
}
    