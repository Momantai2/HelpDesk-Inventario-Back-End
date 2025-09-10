package com.soporteAtenciones.sistemaAtenciones.repository.inventario;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soporteAtenciones.sistemaAtenciones.models.inventario.Area;

public interface AreaRepository extends JpaRepository<Area, Long> {
boolean existsByNombre(String nombre);

}
