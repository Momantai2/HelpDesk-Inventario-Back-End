package com.soporteAtenciones.sistemaAtenciones.repository.equipo.almacenamiento;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soporteAtenciones.sistemaAtenciones.models.equipo.almacenamiento.TipoAlmacenamiento;

public interface TipoAlmacenamientoRepository extends JpaRepository<TipoAlmacenamiento, Long> {
boolean existsByNombre(String nombre);

}
