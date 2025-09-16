package com.soporteAtenciones.sistemaAtenciones.models.Asignacion;

import com.soporteAtenciones.sistemaAtenciones.models.inventario.SubArea;

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
@Table(name ="Colaborador")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Colaborador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idColaborador;

    @Column(nullable = false, unique = false)
    private String nombres;
    
    @Column(nullable = false, unique = false)
    private String apellidos;

    @ManyToOne
    @JoinColumn(name = "idSubArea", nullable = false)
    private SubArea subArea;
}
