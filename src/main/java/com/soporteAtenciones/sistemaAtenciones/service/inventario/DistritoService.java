package com.soporteAtenciones.sistemaAtenciones.service.inventario;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.soporteAtenciones.sistemaAtenciones.dtos.inventario.DistritoRequestDTO;
import com.soporteAtenciones.sistemaAtenciones.dtos.inventario.DistritoResponseDTO;

import com.soporteAtenciones.sistemaAtenciones.mappers.DistritoMapper;
import com.soporteAtenciones.sistemaAtenciones.models.inventario.Distrito;
import com.soporteAtenciones.sistemaAtenciones.repository.inventario.DistritoRepository;

@Service
public class DistritoService {
 private final DistritoRepository distritoRepository;
    private final DistritoMapper distritoMapper;

    public DistritoService(DistritoRepository distritoRepository, DistritoMapper distritoMapper) {
        this.distritoRepository = distritoRepository;
        this.distritoMapper = distritoMapper;
    }

    public List<DistritoResponseDTO> findAll() {
        return distritoRepository.findAll().stream()
                .map(distritoMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    public DistritoResponseDTO findById(Long id) {
        Distrito distrito = distritoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Distrito no encontrado con id: " + id));
        return distritoMapper.toResponseDto(distrito);
    }
    
  public List<DistritoResponseDTO> saveAll(List<DistritoRequestDTO> distritoRequestDTOList) {
    List<Distrito> distritos = distritoRequestDTOList.stream()
            .map(distritoMapper::toEntity)
            .collect(Collectors.toList());

    List<Distrito> guardados = distritoRepository.saveAll(distritos);

    return guardados.stream()
            .map(distritoMapper::toResponseDto)
            .collect(Collectors.toList());
}


    public DistritoResponseDTO save(DistritoRequestDTO distritoRequestDTO) {
        // Validación o lógica de negocio antes de guardar
        Distrito distrito = distritoMapper.toEntity(distritoRequestDTO);
        Distrito saveddistrito = distritoRepository.save(distrito);
        return distritoMapper.toResponseDto(saveddistrito);
    }

    public DistritoResponseDTO update(Long id, DistritoRequestDTO distritoRequestDTO) {
        Distrito existingdistrito = distritoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Distrito no encontrado con id: " + id));
        
        distritoMapper.updateEntityFromDto(distritoRequestDTO, existingdistrito);
        Distrito updatedistrito = distritoRepository.save(existingdistrito);
        return distritoMapper.toResponseDto(updatedistrito);
    }

    public void deleteById(Long id) {
        if (!distritoRepository.existsById(id)) {
            throw new RuntimeException("Distrito no encontrado con id: " + id);
        }
        distritoRepository.deleteById(id);
    }
}