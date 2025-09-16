package com.soporteAtenciones.sistemaAtenciones.models.equipo.memoriaRam;

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
@Table(name ="MemoriaRam")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MemoriaRamEquipo {


@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMemoriaRam;

    @Column(nullable = false, unique = true)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "idTipoMemoriaRam", nullable = false)
    private TipoMemoriaRam tipoMemoriaRam;
}