package com.soporteAtenciones.sistemaAtenciones.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soporteAtenciones.sistemaAtenciones.models.Rol;

public interface RolRepository extends JpaRepository<Rol, Long>{
boolean existsByNombre(String nombre);

}
