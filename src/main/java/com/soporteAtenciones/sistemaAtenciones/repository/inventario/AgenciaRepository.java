package com.soporteAtenciones.sistemaAtenciones.repository.inventario;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soporteAtenciones.sistemaAtenciones.models.inventario.Agencia;

public interface AgenciaRepository  extends JpaRepository <Agencia,Long>{
boolean existsByNombre(String nombre);

}
