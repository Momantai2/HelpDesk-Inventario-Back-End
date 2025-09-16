package com.soporteAtenciones.sistemaAtenciones.repository.equipo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soporteAtenciones.sistemaAtenciones.models.equipo.EstadoEquipo;

public interface EstadoEquipoRepository extends JpaRepository<EstadoEquipo, Long>{
boolean existsByNombre(String nombre);

}
