package com.soporteAtenciones.sistemaAtenciones.repository.inventario;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soporteAtenciones.sistemaAtenciones.models.inventario.TipoSucursal;

public interface TipoSucursalRepository extends JpaRepository<TipoSucursal, Long>{
boolean existsByNombre(String nombre);

}
