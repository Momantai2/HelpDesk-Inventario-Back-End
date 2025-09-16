package com.soporteAtenciones.sistemaAtenciones.repository.equipo.memoriaRam;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soporteAtenciones.sistemaAtenciones.models.equipo.memoriaRam.TipoMemoriaRam;

public interface TipoMemoriaRamRepository extends JpaRepository<TipoMemoriaRam, Long>{
boolean existsByNombre(String nombre);

}
