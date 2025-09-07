package com.soporteAtenciones.sistemaAtenciones.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soporteAtenciones.sistemaAtenciones.models.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Long>{
boolean existsByNombre(String nombre);

}
