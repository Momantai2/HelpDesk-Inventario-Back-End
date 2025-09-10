package com.soporteAtenciones.sistemaAtenciones.models.inventario;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor 
@AllArgsConstructor
@Entity
@Table(name ="Area")
public class Area {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idArea;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String nombre;

  
}
    