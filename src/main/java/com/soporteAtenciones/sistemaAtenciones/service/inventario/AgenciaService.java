package com.soporteAtenciones.sistemaAtenciones.service.inventario;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.soporteAtenciones.sistemaAtenciones.dtos.inventario.AgenciaRequestDTO;
import com.soporteAtenciones.sistemaAtenciones.dtos.inventario.AgenciaResponseDTO;
import com.soporteAtenciones.sistemaAtenciones.mappers.AgenciaMapper;
import com.soporteAtenciones.sistemaAtenciones.models.inventario.Agencia;
import com.soporteAtenciones.sistemaAtenciones.repository.inventario.AgenciaRepository;

@Service
public class AgenciaService {
 private final AgenciaRepository agenciaRepository;
    private final AgenciaMapper agenciaMapper;

    public AgenciaService(AgenciaRepository agenciaRepository, AgenciaMapper agenciaMapper) {
        this.agenciaRepository = agenciaRepository;
        this.agenciaMapper = agenciaMapper;
    }

    public List<AgenciaResponseDTO> findAll() {
        return agenciaRepository.findAll().stream()
                .map(agenciaMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    public AgenciaResponseDTO findById(Long id) {
        Agencia agencia = agenciaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agencia no encontrado con id: " + id));
        return agenciaMapper.toResponseDto(agencia);
    }

    public List<AgenciaResponseDTO> saveAll(List<AgenciaRequestDTO> agenciaRequestDTOList) {
    List<Agencia> agencias = agenciaRequestDTOList.stream()
            .map(agenciaMapper::toEntity)
            .collect(Collectors.toList());

    List<Agencia> guardados = agenciaRepository.saveAll(agencias);

    return guardados.stream()
            .map(agenciaMapper::toResponseDto)
            .collect(Collectors.toList());
}

 

    public AgenciaResponseDTO save(AgenciaRequestDTO agenciaRequestDTO) {
        // Validación o lógica de negocio antes de guardar
        Agencia agencia = agenciaMapper.toEntity(agenciaRequestDTO);
        Agencia savedagencia = agenciaRepository.save(agencia);
        return agenciaMapper.toResponseDto(savedagencia);
    }

    public AgenciaResponseDTO update(Long id, AgenciaRequestDTO agenciaRequestDTO) {
        Agencia existingagencia = agenciaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agencia no encontrado con id: " + id));
        
        agenciaMapper.updateEntityFromDto(agenciaRequestDTO, existingagencia);
        Agencia updateagencia = agenciaRepository.save(existingagencia);
        return agenciaMapper.toResponseDto(updateagencia);
    }

    public void deleteById(Long id) {
        if (!agenciaRepository.existsById(id)) {
            throw new RuntimeException("Agencia no encontrado con id: " + id);
        }
        agenciaRepository.deleteById(id);
    }
}