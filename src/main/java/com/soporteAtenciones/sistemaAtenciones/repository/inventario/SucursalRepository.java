package com.soporteAtenciones.sistemaAtenciones.repository.inventario;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soporteAtenciones.sistemaAtenciones.models.inventario.Sucursal;

public interface SucursalRepository extends JpaRepository<Sucursal, Long> {
boolean existsByNombre(String nombre);

}
