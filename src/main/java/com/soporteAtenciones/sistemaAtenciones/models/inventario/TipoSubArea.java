package com.soporteAtenciones.sistemaAtenciones.models.inventario;

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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tipoSubArea¨")
 public class TipoSubArea {

  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipoSubArea;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "idArea", nullable = false)
    private Area area;

}
    