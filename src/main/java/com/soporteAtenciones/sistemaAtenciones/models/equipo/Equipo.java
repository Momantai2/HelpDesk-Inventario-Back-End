package com.soporteAtenciones.sistemaAtenciones.models.equipo;


import java.time.LocalDateTime;

import com.soporteAtenciones.sistemaAtenciones.models.equipo.almacenamiento.AlmacenamientoEquipo;
import com.soporteAtenciones.sistemaAtenciones.models.equipo.memoriaRam.MemoriaRamEquipo;
import com.soporteAtenciones.sistemaAtenciones.models.equipo.procesador.ProcesadorEquipo;

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
@Table(name ="Equipo")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Equipo {

@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEquipo;

    @Column(nullable = false, unique = true)
    private String nroSerie;

    @ManyToOne
    @JoinColumn(name = "idAlmacenamiento", nullable = true)
    private AlmacenamientoEquipo almacenamientoEquipo;
    @ManyToOne
    @JoinColumn(name = "idMemoriaRam", nullable = true)
    private MemoriaRamEquipo memoriaRamEquipo;
    @ManyToOne
    @JoinColumn(name = "idProcesador", nullable = true)
    private ProcesadorEquipo procesadorEquipo;
    @ManyToOne
    @JoinColumn(name = "idEstadoEquipo", nullable = false)
    private EstadoEquipo estadoEquipo;
    @ManyToOne
    @JoinColumn(name = "idMarcaEquipo", nullable = false)
    private MarcaEquipo marcaEquipo;
    @ManyToOne
    @JoinColumn(name = "idModeloEquipo", nullable = false)
    private ModeloEquipo modeloEquipo;
     @ManyToOne
    @JoinColumn(name = "idTipoEquipo", nullable = false)
    private TipoEquipo tipoEquipo;
    @ManyToOne
    @JoinColumn(name = "idLote", nullable = true)
    private LoteProovedor loteProovedor;

    @Column(nullable = false, unique = false)
    private LocalDateTime FechaUltimoInventario;

    @Column(nullable = true, unique = false)
    private String Observacion;
}
