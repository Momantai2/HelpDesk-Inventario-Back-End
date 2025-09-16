package com.soporteAtenciones.sistemaAtenciones.models.equipo;

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
@Table(name ="EstadoEquipo")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EstadoEquipo {

@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEstadoEquipo;

    @Column(nullable = false, unique = true)
    private String nombre;
}