package com.soporteAtenciones.sistemaAtenciones.repository.inventario;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soporteAtenciones.sistemaAtenciones.models.inventario.Provincia;

public interface ProvinciaRepository extends JpaRepository<Provincia,Long> {
    boolean existsByNombre(String nombre);

}
