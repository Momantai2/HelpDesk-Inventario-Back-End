package com.soporteAtenciones.sistemaAtenciones.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soporteAtenciones.sistemaAtenciones.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
boolean existsByEmail(String email);
Usuario findByEmail(String email);

}
