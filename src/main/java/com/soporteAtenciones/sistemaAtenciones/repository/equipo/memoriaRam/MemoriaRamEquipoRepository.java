package com.soporteAtenciones.sistemaAtenciones.repository.equipo.memoriaRam;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soporteAtenciones.sistemaAtenciones.models.equipo.memoriaRam.MemoriaRamEquipo;

public interface MemoriaRamEquipoRepository extends JpaRepository<MemoriaRamEquipo, Long> {
boolean existsByNombre(String nombre);

}
