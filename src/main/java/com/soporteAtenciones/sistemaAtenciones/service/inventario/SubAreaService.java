package com.soporteAtenciones.sistemaAtenciones.service.inventario;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.soporteAtenciones.sistemaAtenciones.dtos.inventario.SubAreaRequestDTO;
import com.soporteAtenciones.sistemaAtenciones.dtos.inventario.SubAreaResponseDTO;
import com.soporteAtenciones.sistemaAtenciones.mappers.SubAreaMapper;
import com.soporteAtenciones.sistemaAtenciones.models.inventario.SubArea;
import com.soporteAtenciones.sistemaAtenciones.repository.inventario.SubAreaRepository;

@Service
public class SubAreaService {

    private final SubAreaRepository subAreaRepository;
    private final SubAreaMapper subAreaMapper;

    public SubAreaService(SubAreaRepository subAreaRepository, SubAreaMapper subAreaMapper) {
        this.subAreaRepository = subAreaRepository;
        this.subAreaMapper = subAreaMapper;
    }

    public List<SubAreaResponseDTO> findAll() {
        return subAreaRepository.findAll().stream()
                .map(subAreaMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    public SubAreaResponseDTO findById(Long id) {
        SubArea subarea = subAreaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("SubArea no encontrado con id: " + id));
        return subAreaMapper.toResponseDto(subarea);
    }
    
    public List<SubAreaResponseDTO> saveAll(List<SubAreaRequestDTO> subareaRequestDTOList) {
    List<SubArea> subareas = subareaRequestDTOList.stream()
            .map(subAreaMapper::toEntity)
            .collect(Collectors.toList());

    List<SubArea> guardados = subAreaRepository.saveAll(subareas);

    return guardados.stream()
            .map(subAreaMapper::toResponseDto)
            .collect(Collectors.toList());
}

 

    public SubAreaResponseDTO save(SubAreaRequestDTO subareaRequestDTO) {
        // Validación o lógica de negocio antes de guardar
        SubArea subarea = subAreaMapper.toEntity(subareaRequestDTO);
        SubArea savedsubarea = subAreaRepository.save(subarea);
        return subAreaMapper.toResponseDto(savedsubarea);
    }

    public SubAreaResponseDTO update(Long id, SubAreaRequestDTO subareaRequestDTO) {
        SubArea existingsubarea = subAreaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("SubArea no encontrado con id: " + id));
        
        subAreaMapper.updateEntityFromDto(subareaRequestDTO, existingsubarea);
        SubArea updatesubarea = subAreaRepository.save(existingsubarea);
        return subAreaMapper.toResponseDto(updatesubarea);
    }

    public void deleteById(Long id) {
        if (!subAreaRepository.existsById(id)) {
            throw new RuntimeException("SubArea no encontrado con id: " + id);
        }
        subAreaRepository.deleteById(id);
    }
}