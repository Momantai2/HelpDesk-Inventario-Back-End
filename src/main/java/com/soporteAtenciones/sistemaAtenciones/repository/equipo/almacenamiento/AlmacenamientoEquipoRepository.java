package com.soporteAtenciones.sistemaAtenciones.repository.equipo.almacenamiento;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soporteAtenciones.sistemaAtenciones.models.equipo.almacenamiento.AlmacenamientoEquipo;

public interface AlmacenamientoEquipoRepository extends JpaRepository<AlmacenamientoEquipo, Long>{
boolean existsByNombre(String nombre);

}
