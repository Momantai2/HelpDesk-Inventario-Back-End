package com.soporteAtenciones.sistemaAtenciones.repository.equipo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soporteAtenciones.sistemaAtenciones.models.equipo.TipoEquipo;

public interface TipoEquipoRepository extends JpaRepository<TipoEquipo, Long>{
boolean existsByNombre(String nombre);

}
