package com.soporteAtenciones.sistemaAtenciones.repository.equipo.procesador;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soporteAtenciones.sistemaAtenciones.models.equipo.procesador.ProcesadorEquipo;

public interface ProcesadorEquipoRepository extends JpaRepository<ProcesadorEquipo, Long>{
boolean existsByNombre(String nombre);

}
