package com.soporteAtenciones.sistemaAtenciones.models.equipo;
import java.time.LocalDateTime;

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
@Table(name ="LoteProovedor")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoteProovedor {


@Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLote;

    @Column(nullable = false, unique = true)
    private String nombre;

    @Column(nullable = false, unique = false)
    private LocalDateTime FechaIngresoRenting;

    @Column(nullable = false, unique = false)
    private LocalDateTime FechVencimientoRenting;

    @ManyToOne
    @JoinColumn(name = "idProovedor", nullable = false)
    private ProovedorRenting proovedor;


}