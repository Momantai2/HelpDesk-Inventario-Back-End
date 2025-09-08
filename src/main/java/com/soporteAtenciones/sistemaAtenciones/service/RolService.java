
package com.soporteAtenciones.sistemaAtenciones.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soporteAtenciones.sistemaAtenciones.dtos.tickets.RolRequestDTO;
import com.soporteAtenciones.sistemaAtenciones.dtos.tickets.RolResponseDTO;
import com.soporteAtenciones.sistemaAtenciones.mappers.RolMapper;
import com.soporteAtenciones.sistemaAtenciones.models.Rol;
import com.soporteAtenciones.sistemaAtenciones.repository.RolRepository;

@Service
public class RolService {

    private final RolRepository rolRepository;
    private final RolMapper rolMapper;

    @Autowired
    public RolService(RolRepository rolRepository, RolMapper rolMapper) {
        this.rolRepository = rolRepository;
        this.rolMapper = rolMapper;
    }

    public List<RolResponseDTO> findAll() {
        return rolRepository.findAll().stream()
                .map(rolMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    public RolResponseDTO findById(Long id) {
        Rol rol = rolRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado con id: " + id));
        return rolMapper.toResponseDto(rol);
    }

    public RolResponseDTO crearRol(RolRequestDTO rolRequestDTO) {
        Rol rol = rolMapper.toEntity(rolRequestDTO);
        Rol savedRol = rolRepository.save(rol);
        return rolMapper.toResponseDto(savedRol);
    }

    public RolResponseDTO update(Long id, RolRequestDTO rolRequestDTO) {
        Rol existingRol = rolRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado con id: " + id));
        
        rolMapper.updateEntityFromDto(rolRequestDTO, existingRol);
        Rol updatedRol = rolRepository.save(existingRol);
        return rolMapper.toResponseDto(updatedRol);
    }

    public void deleteById(Long id) {
        if (!rolRepository.existsById(id)) {
            throw new RuntimeException("Rol no encontrado con id: " + id);
        }
        rolRepository.deleteById(id);
    }
}