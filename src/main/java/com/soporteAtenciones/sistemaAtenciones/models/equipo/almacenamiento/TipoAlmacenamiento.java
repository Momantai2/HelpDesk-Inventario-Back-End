package com.soporteAtenciones.sistemaAtenciones.models.equipo.almacenamiento;
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
@Table(name ="TipoAlmacenamiento")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TipoAlmacenamiento {

@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipoAlmacenamiento;

    @Column(nullable = false, unique = true)
    private String nombre;
}