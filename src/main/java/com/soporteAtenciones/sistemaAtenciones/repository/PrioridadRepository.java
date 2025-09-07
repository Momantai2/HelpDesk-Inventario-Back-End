package com.soporteAtenciones.sistemaAtenciones.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soporteAtenciones.sistemaAtenciones.models.Prioridad;

public interface PrioridadRepository extends JpaRepository<Prioridad, Long>{
boolean existsByNombre(String nombre);

}
