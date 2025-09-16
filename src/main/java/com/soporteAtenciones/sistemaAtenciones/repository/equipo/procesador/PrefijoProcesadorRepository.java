package com.soporteAtenciones.sistemaAtenciones.repository.equipo.procesador;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soporteAtenciones.sistemaAtenciones.models.equipo.procesador.PrefijoProcesador;

public interface PrefijoProcesadorRepository extends JpaRepository<PrefijoProcesador, Long>{
boolean existsByNombre(String nombre);

}
