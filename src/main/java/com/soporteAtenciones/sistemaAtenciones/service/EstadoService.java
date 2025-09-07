package com.soporteAtenciones.sistemaAtenciones.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.soporteAtenciones.sistemaAtenciones.exception.DuplicateResourceException;
import com.soporteAtenciones.sistemaAtenciones.exception.ResourceNotFoundException;
import com.soporteAtenciones.sistemaAtenciones.models.Estado;
import com.soporteAtenciones.sistemaAtenciones.repository.EstadoRepository;

import jakarta.transaction.Transactional;

@Service
public class EstadoService {
  private final EstadoRepository estadoRepository;

    public EstadoService(EstadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
    }

    @Transactional 
      public Estado crearEstado(Estado usuario) {
        if (estadoRepository.existsByNombre(usuario.getNombre())) {
            throw new DuplicateResourceException("Estado", "nombre", usuario.getNombre());
        }
        // fechaCreacion se setea con @PrePersist
        return estadoRepository.save(usuario);
    }

    public Estado obtenerEstadoPorId(Long id) {
        return estadoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Estado", "id", id));
    }

    public List<Estado> listarEstados() {
        return estadoRepository.findAll();
    }

    @Transactional
    public Estado actualizarEstado(Long id, Estado ticketActualizado) {
        Estado existente = obtenerEstadoPorId(id);

        existente.setNombre(ticketActualizado.getNombre());
        return estadoRepository.save(existente);
    }

    @Transactional
    public void eliminarEstado(Long id) {
        Estado existente = obtenerEstadoPorId(id);
        estadoRepository.delete(existente);
    }
}