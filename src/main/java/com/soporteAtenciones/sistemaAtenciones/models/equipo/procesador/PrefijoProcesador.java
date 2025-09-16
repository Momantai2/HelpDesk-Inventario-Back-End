package com.soporteAtenciones.sistemaAtenciones.models.equipo.procesador;
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
@Table(name ="PrefijoProcesador")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PrefijoProcesador {

@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPrefijoProcesador;

    @Column(nullable = false, unique = true)
    private String nombre;
}