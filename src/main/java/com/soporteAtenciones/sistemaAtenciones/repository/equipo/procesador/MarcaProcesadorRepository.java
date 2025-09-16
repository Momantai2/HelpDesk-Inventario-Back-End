package com.soporteAtenciones.sistemaAtenciones.repository.equipo.procesador;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soporteAtenciones.sistemaAtenciones.models.equipo.procesador.MarcaProcesador;

public interface MarcaProcesadorRepository extends JpaRepository<MarcaProcesador, Long>{
boolean existsByNombre(String nombre);

}
