package com.soporteAtenciones.sistemaAtenciones.models.inventario;


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
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "subArea")
public class SubArea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSubArea;

    @ManyToOne
    @JoinColumn(name = "idTipoSubArea", nullable = false)
    private TipoSubArea tipoSubArea;

     @ManyToOne
    @JoinColumn(name = "idSucursal", nullable = false)
    private Sucursal sucursal;
}
