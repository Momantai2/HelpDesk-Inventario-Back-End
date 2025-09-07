package com.soporteAtenciones.sistemaAtenciones.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="Prioridad")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Prioridad {
  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPrioridad;

    @Column(nullable = false, unique = true)
    private String nombre;

     private LocalDateTime FechaCreacion;

    @PrePersist
    protected void onCreate() {
        this.FechaCreacion = LocalDateTime.now();
    }
}
