package com.soporteAtenciones.sistemaAtenciones.repository.equipo.procesador;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soporteAtenciones.sistemaAtenciones.models.equipo.procesador.GeneracionProcesador;

public interface GeneracionProcesadorRepository extends JpaRepository<GeneracionProcesador, Long> {
boolean existsByNombre(String nombre);

}
