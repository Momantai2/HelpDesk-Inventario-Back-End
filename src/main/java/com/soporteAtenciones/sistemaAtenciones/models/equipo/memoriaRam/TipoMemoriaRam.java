package com.soporteAtenciones.sistemaAtenciones.models.equipo.memoriaRam;
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
@Table(name ="TipoMemoriaRam")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TipoMemoriaRam {

@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipoMemoriaRam;

    @Column(nullable = false, unique = true)
    private String nombre;
}
