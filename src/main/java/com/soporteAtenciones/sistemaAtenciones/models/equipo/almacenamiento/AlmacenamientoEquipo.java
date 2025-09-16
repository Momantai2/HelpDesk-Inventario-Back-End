package com.soporteAtenciones.sistemaAtenciones.models.equipo.almacenamiento;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="AlmacenamientoEquipo")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AlmacenamientoEquipo {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAlmacenamiento;

    @Column(nullable = false, unique = true)
    private String nombre;
    
     @ManyToOne
    @JoinColumn(name = "idTipoAlmacenamiento", nullable = false)
    private TipoAlmacenamiento tipoAlmacenamiento;
}