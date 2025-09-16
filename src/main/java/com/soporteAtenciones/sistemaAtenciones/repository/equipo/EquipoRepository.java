package com.soporteAtenciones.sistemaAtenciones.repository.equipo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soporteAtenciones.sistemaAtenciones.models.equipo.Equipo;

public interface EquipoRepository extends JpaRepository<Equipo, Long> {
boolean existsByNombre(String nombre);

}
