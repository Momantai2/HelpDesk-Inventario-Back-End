package com.soporteAtenciones.sistemaAtenciones.service.inventario;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.soporteAtenciones.sistemaAtenciones.dtos.inventario.AreaRequestDTO;
import com.soporteAtenciones.sistemaAtenciones.dtos.inventario.AreaResponseDTO;
import com.soporteAtenciones.sistemaAtenciones.mappers.AreaMapper;
import com.soporteAtenciones.sistemaAtenciones.models.inventario.Area;
import com.soporteAtenciones.sistemaAtenciones.repository.inventario.AreaRepository;

@Service
public class AreaService {

 private final AreaRepository areaRepository;
    private final AreaMapper areaMapper;

    
    public AreaService(AreaRepository areaRepository, AreaMapper areaMapper) {
        this.areaRepository = areaRepository;
        this.areaMapper = areaMapper;
    }

    public List<AreaResponseDTO> findAll() {
        return areaRepository.findAll().stream()
                .map(areaMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    public AreaResponseDTO findById(Long id) {
        Area area = areaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Area no encontrado con id: " + id));
        return areaMapper.toResponseDto(area);
    }
    
    public List<AreaResponseDTO> saveAll(List<AreaRequestDTO> areaRequestDTOList) {
    List<Area> areas = areaRequestDTOList.stream()
            .map(areaMapper::toEntity)
            .collect(Collectors.toList());

    List<Area> guardados = areaRepository.saveAll(areas);

    return guardados.stream()
            .map(areaMapper::toResponseDto)
            .collect(Collectors.toList());
}

 

    public AreaResponseDTO save(AreaRequestDTO areaRequestDTO) {
        // Validación o lógica de negocio antes de guardar
        Area area = areaMapper.toEntity(areaRequestDTO);
        Area savedarea = areaRepository.save(area);
        return areaMapper.toResponseDto(savedarea);
    }

    public AreaResponseDTO update(Long id, AreaRequestDTO areaRequestDTO) {
        Area existingarea = areaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Area no encontrado con id: " + id));
        
        areaMapper.updateEntityFromDto(areaRequestDTO, existingarea);
        Area updatearea = areaRepository.save(existingarea);
        return areaMapper.toResponseDto(updatearea);
    }

    public void deleteById(Long id) {
        if (!areaRepository.existsById(id)) {
            throw new RuntimeException("Area no encontrado con id: " + id);
        }
        areaRepository.deleteById(id);
    }
}