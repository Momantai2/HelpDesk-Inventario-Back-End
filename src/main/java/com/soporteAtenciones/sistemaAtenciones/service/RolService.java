package com.soporteAtenciones.sistemaAtenciones.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.soporteAtenciones.sistemaAtenciones.exception.DuplicateResourceException;
import com.soporteAtenciones.sistemaAtenciones.exception.ResourceNotFoundException;
import com.soporteAtenciones.sistemaAtenciones.models.Rol;
import com.soporteAtenciones.sistemaAtenciones.repository.RolRepository;

import jakarta.transaction.Transactional;

@Service
public class RolService {

 private final RolRepository rolRepository;

    public RolService(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    @Transactional
      public Rol crearRol(Rol usuario) {
        if (rolRepository.existsByNombre(usuario.getNombre())) {
            throw new DuplicateResourceException("Rol", "nombre", usuario.getNombre());
        }
        // fechaCreacion se setea con @PrePersist
        return rolRepository.save(usuario);
    }

    public Rol obtenerRolPorId(Long id) {
        return rolRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rol", "id", id));
    }

    public List<Rol> listarRoles() {
        return rolRepository.findAll();
    }

    @Transactional
    public Rol actualizarRol(Long id, Rol ticketActualizado) {
        Rol existente = obtenerRolPorId(id);

        existente.setNombre(ticketActualizado.getNombre());
        return rolRepository.save(existente);
    }

    @Transactional
    public void eliminarRol(Long id) {
        Rol existente = obtenerRolPorId(id);
        rolRepository.delete(existente);
    }
}