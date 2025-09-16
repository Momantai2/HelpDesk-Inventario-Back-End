package com.soporteAtenciones.sistemaAtenciones.repository.equipo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soporteAtenciones.sistemaAtenciones.models.equipo.ProovedorRenting;

public interface ProovedorRentingRepository extends JpaRepository<ProovedorRenting, Long>{
boolean existsByNombre(String nombre);

}
