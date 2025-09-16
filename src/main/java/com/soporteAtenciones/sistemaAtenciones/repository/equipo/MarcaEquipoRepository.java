package com.soporteAtenciones.sistemaAtenciones.repository.equipo;
import org.springframework.data.jpa.repository.JpaRepository;

import com.soporteAtenciones.sistemaAtenciones.models.equipo.MarcaEquipo;

public interface MarcaEquipoRepository extends JpaRepository<MarcaEquipo, Long> {
boolean existsByNombre(String nombre);

}
