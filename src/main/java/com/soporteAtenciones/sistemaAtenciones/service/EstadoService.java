
package com.soporteAtenciones.sistemaAtenciones.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soporteAtenciones.sistemaAtenciones.dtos.tickets.EstadoRequestDTO;
import com.soporteAtenciones.sistemaAtenciones.dtos.tickets.EstadoResponseDTO;
import com.soporteAtenciones.sistemaAtenciones.mappers.EstadoMapper;
import com.soporteAtenciones.sistemaAtenciones.models.Estado;
import com.soporteAtenciones.sistemaAtenciones.repository.EstadoRepository;

@Service
public class EstadoService {

    private final EstadoRepository estadoRepository;
    private final EstadoMapper estadoMapper;

    @Autowired
    public EstadoService(EstadoRepository estadoRepository, EstadoMapper estadoMapper) {
        this.estadoRepository = estadoRepository;
        this.estadoMapper = estadoMapper;
    }

    public List<EstadoResponseDTO> findAll() {
        return estadoRepository.findAll().stream()
                .map(estadoMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    public EstadoResponseDTO findById(Long id) {
        Estado estado = estadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estado no encontrado con id: " + id));
        return estadoMapper.toResponseDto(estado);
    }

    public EstadoResponseDTO save(EstadoRequestDTO estadoRequestDTO) {
        Estado estado = estadoMapper.toEntity(estadoRequestDTO);
        Estado savedEstado = estadoRepository.save(estado);
        return estadoMapper.toResponseDto(savedEstado);
    }

    public EstadoResponseDTO update(Long id, EstadoRequestDTO estadoRequestDTO) {
        Estado existingEstado = estadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estado no encontrado con id: " + id));
        
        estadoMapper.updateEntityFromDto(estadoRequestDTO, existingEstado);
        Estado updatedEstado = estadoRepository.save(existingEstado);
        return estadoMapper.toResponseDto(updatedEstado);
    }

    public void deleteById(Long id) {
        if (!estadoRepository.existsById(id)) {
            throw new RuntimeException("Estado no encontrado con id: " + id);
        }
        estadoRepository.deleteById(id);
    }
}