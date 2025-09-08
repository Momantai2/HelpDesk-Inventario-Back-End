package com.soporteAtenciones.sistemaAtenciones.service;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soporteAtenciones.sistemaAtenciones.dtos.tickets.PrioridadRequestDTO;
import com.soporteAtenciones.sistemaAtenciones.dtos.tickets.PrioridadResponseDTO;
import com.soporteAtenciones.sistemaAtenciones.mappers.PrioridadMapper;
import com.soporteAtenciones.sistemaAtenciones.models.Prioridad;
import com.soporteAtenciones.sistemaAtenciones.repository.PrioridadRepository;

@Service
public class PrioridadService {

    private final PrioridadRepository prioridadRepository;
    private final PrioridadMapper prioridadMapper;

    @Autowired
    public PrioridadService(PrioridadRepository prioridadRepository, PrioridadMapper prioridadMapper) {
        this.prioridadRepository = prioridadRepository;
        this.prioridadMapper = prioridadMapper;
    }

    public List<PrioridadResponseDTO> findAll() {
        return prioridadRepository.findAll().stream()
                .map(prioridadMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    public PrioridadResponseDTO findById(Long id) {
        Prioridad prioridad = prioridadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prioridad no encontrada con id: " + id));
        return prioridadMapper.toResponseDto(prioridad);
    }

    public PrioridadResponseDTO save(PrioridadRequestDTO prioridadRequestDTO) {
        Prioridad prioridad = prioridadMapper.toEntity(prioridadRequestDTO);
        Prioridad savedPrioridad = prioridadRepository.save(prioridad);
        return prioridadMapper.toResponseDto(savedPrioridad);
    }

    public PrioridadResponseDTO update(Long id, PrioridadRequestDTO prioridadRequestDTO) {
        Prioridad existingPrioridad = prioridadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prioridad no encontrada con id: " + id));
        
        prioridadMapper.updateEntityFromDto(prioridadRequestDTO, existingPrioridad);
        Prioridad updatedPrioridad = prioridadRepository.save(existingPrioridad);
        return prioridadMapper.toResponseDto(updatedPrioridad);
    }

    public void deleteById(Long id) {
        if (!prioridadRepository.existsById(id)) {
            throw new RuntimeException("Prioridad no encontrada con id: " + id);
        }
        prioridadRepository.deleteById(id);
    }
}