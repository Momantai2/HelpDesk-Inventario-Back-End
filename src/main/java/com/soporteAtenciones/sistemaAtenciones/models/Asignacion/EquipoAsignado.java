package com.soporteAtenciones.sistemaAtenciones.models.Asignacion;


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

import java.time.LocalDateTime;

import com.soporteAtenciones.sistemaAtenciones.models.equipo.Equipo;

@Entity
@Table(name ="EquipoAsignado")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EquipoAsignado {

  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEquipoAsignado;

    @ManyToOne
    @JoinColumn(name = "idEquipo", nullable = false)
    private Equipo equipo;

    @ManyToOne
    @JoinColumn(name = "idColaborador", nullable = false)
    private Colaborador colaborador;
    
    @Column(nullable = false, unique = false)
    private LocalDateTime FechaAsignacion;

    @Column(nullable = false, unique = false)
    private LocalDateTime FechaDevolucion;
}
