package com.soporteAtenciones.sistemaAtenciones.service.inventario;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;


import com.soporteAtenciones.sistemaAtenciones.dtos.inventario.ProvinciaRequestDTO;
import com.soporteAtenciones.sistemaAtenciones.dtos.inventario.ProvinciaResponseDTO;
import com.soporteAtenciones.sistemaAtenciones.mappers.ProvinciaMapper;
import com.soporteAtenciones.sistemaAtenciones.models.inventario.Provincia;
import com.soporteAtenciones.sistemaAtenciones.repository.inventario.ProvinciaRepository;

@Service
public class ProvinciaService {

      private final ProvinciaRepository provinciaRepository;
    private final ProvinciaMapper provinciaMapper;

    public ProvinciaService(ProvinciaRepository provinciaRepository, ProvinciaMapper provinciaMapper) {
        this.provinciaRepository = provinciaRepository;
        this.provinciaMapper = provinciaMapper;
    }

    public List<ProvinciaResponseDTO> findAll() {
        return provinciaRepository.findAll().stream()
                .map(provinciaMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    public ProvinciaResponseDTO findById(Long id) {
        Provincia provincia = provinciaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Provincia no encontrado con id: " + id));
        return provinciaMapper.toResponseDto(provincia);
    }
    
 public List<ProvinciaResponseDTO> saveAll(List<ProvinciaRequestDTO> provinciaRequestDTOList) {
    List<Provincia> provincias = provinciaRequestDTOList.stream()
            .map(provinciaMapper::toEntity)
            .collect(Collectors.toList());

    List<Provincia> guardados = provinciaRepository.saveAll(provincias);

    return guardados.stream()
            .map(provinciaMapper::toResponseDto)
            .collect(Collectors.toList());
}

    public ProvinciaResponseDTO save(ProvinciaRequestDTO provinciaRequestDTO) {
        // Validación o lógica de negocio antes de guardar
        Provincia provincia = provinciaMapper.toEntity(provinciaRequestDTO);
        Provincia savedprovincia = provinciaRepository.save(provincia);
        return provinciaMapper.toResponseDto(savedprovincia);
    }

    public ProvinciaResponseDTO update(Long id, ProvinciaRequestDTO provinciaRequestDTO) {
        Provincia existingprovincia = provinciaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Provincia no encontrado con id: " + id));
        
        provinciaMapper.updateEntityFromDto(provinciaRequestDTO, existingprovincia);
        Provincia updateprovincia = provinciaRepository.save(existingprovincia);
        return provinciaMapper.toResponseDto(updateprovincia);
    }

    public void deleteById(Long id) {
        if (!provinciaRepository.existsById(id)) {
            throw new RuntimeException("Provincia no encontrado con id: " + id);
        }
        provinciaRepository.deleteById(id);
    }
}