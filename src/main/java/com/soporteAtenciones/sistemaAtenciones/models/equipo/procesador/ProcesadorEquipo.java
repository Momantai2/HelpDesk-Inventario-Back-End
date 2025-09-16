package com.soporteAtenciones.sistemaAtenciones.models.equipo.procesador;
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
@Table(name ="Procesador")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProcesadorEquipo {

@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProcesador;


    @Column(nullable = false, unique = true)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "idMarcaProcesador", nullable = false)
    private MarcaProcesador marcaProcesador;

    @ManyToOne
    @JoinColumn(name = "idGeneracionProcesador", nullable = false)
    private GeneracionProcesador generacionProcesador;
}
   