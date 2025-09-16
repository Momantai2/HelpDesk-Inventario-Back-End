package com.soporteAtenciones.sistemaAtenciones.repository.equipo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soporteAtenciones.sistemaAtenciones.models.equipo.LoteProovedor;

public interface LoteProovedorRepository extends JpaRepository<LoteProovedor, Long> {
boolean existsByNombre(String nombre);

}
