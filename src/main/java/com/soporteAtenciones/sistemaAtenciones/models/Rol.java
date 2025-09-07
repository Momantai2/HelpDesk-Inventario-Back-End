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
@Table(name ="Rol")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Rol {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRol;

@Column(nullable = false, unique = true)
private String nombre;


 private LocalDateTime FechaCreacion;

    @PrePersist
    protected void onCreate() {
        this.FechaCreacion = LocalDateTime.now();
    }
}
