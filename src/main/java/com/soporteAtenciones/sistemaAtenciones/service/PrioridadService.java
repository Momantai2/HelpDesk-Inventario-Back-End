package com.soporteAtenciones.sistemaAtenciones.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.soporteAtenciones.sistemaAtenciones.exception.DuplicateResourceException;
import com.soporteAtenciones.sistemaAtenciones.exception.ResourceNotFoundException;
import com.soporteAtenciones.sistemaAtenciones.models.Prioridad;
import com.soporteAtenciones.sistemaAtenciones.repository.PrioridadRepository;

import jakarta.transaction.Transactional;


@Service
public class PrioridadService {

  private final PrioridadRepository prioridadRepository;

    public PrioridadService(PrioridadRepository prioridadRepository) {
        this.prioridadRepository = prioridadRepository;
    }

    @Transactional
      public Prioridad crearPrioridad(Prioridad usuario) {
        if (prioridadRepository.existsByNombre(usuario.getNombre())) {
            throw new DuplicateResourceException("Prioridad", "nombre", usuario.getNombre());
        }
        // fechaCreacion se setea con @PrePersist
        return prioridadRepository.save(usuario);
    }

    public Prioridad obtenerPrioridadPorId(Long id) {
        return prioridadRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Prioridad", "id", id));
    }

    public List<Prioridad> listarPrioridades() {
        return prioridadRepository.findAll();
    }

    @Transactional
    public Prioridad actualizarPrioridad(Long id, Prioridad ticketActualizado) {
        Prioridad existente = obtenerPrioridadPorId(id);

        existente.setNombre(ticketActualizado.getNombre());
        return prioridadRepository.save(existente);
    }

    @Transactional
    public void eliminarPrioridad(Long id) {
        Prioridad existente = obtenerPrioridadPorId(id);
        prioridadRepository.delete(existente);
    }
}