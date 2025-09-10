package com.soporteAtenciones.sistemaAtenciones.service.inventario;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.soporteAtenciones.sistemaAtenciones.dtos.inventario.TipoSubAreaRequest;
import com.soporteAtenciones.sistemaAtenciones.dtos.inventario.TipoSubAreaResponse;
import com.soporteAtenciones.sistemaAtenciones.mappers.TipoSubAreaMapper;
import com.soporteAtenciones.sistemaAtenciones.models.inventario.TipoSubArea;
import com.soporteAtenciones.sistemaAtenciones.repository.inventario.TipoSubAreaRepository;

@Service
public class TipoSubAreaService {


 private final TipoSubAreaRepository tipoSubAreaRepository;
    private final TipoSubAreaMapper tipoSubAreaMapper;

    
    public TipoSubAreaService(TipoSubAreaRepository tipoSubAreaRepository, TipoSubAreaMapper tipoSubAreaMapper) {
        this.tipoSubAreaRepository = tipoSubAreaRepository;
        this.tipoSubAreaMapper = tipoSubAreaMapper;
    }

    public List<TipoSubAreaResponse> findAll() {
        return tipoSubAreaRepository.findAll().stream()
                .map(tipoSubAreaMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    public TipoSubAreaResponse findById(Long id) {
        TipoSubArea tiposubarea = tipoSubAreaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tipo Sub Area no encontrado con id: " + id));
        return tipoSubAreaMapper.toResponseDto(tiposubarea);
    }
    
    public List<TipoSubAreaResponse> saveAll(List<TipoSubAreaRequest> tiposubarearequest) {
    List<TipoSubArea> tiposubarea = tiposubarearequest.stream()
            .map(tipoSubAreaMapper::toEntity)
            .collect(Collectors.toList());

    List<TipoSubArea> guardados = tipoSubAreaRepository.saveAll(tiposubarea);

    return guardados.stream()
            .map(tipoSubAreaMapper::toResponseDto)
            .collect(Collectors.toList());
}

 

    public TipoSubAreaResponse save(TipoSubAreaRequest tiposubarearequest) {
        // Validación o lógica de negocio antes de guardar
        TipoSubArea area = tipoSubAreaMapper.toEntity(tiposubarearequest);
        TipoSubArea savedarea = tipoSubAreaRepository.save(area);
        return tipoSubAreaMapper.toResponseDto(savedarea);
    }

    public TipoSubAreaResponse update(Long id, TipoSubAreaRequest areaRequestDTO) {
        TipoSubArea existingarea = tipoSubAreaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Area no encontrado con id: " + id));
        
        tipoSubAreaMapper.updateEntityFromDto(areaRequestDTO, existingarea);
        TipoSubArea updatearea = tipoSubAreaRepository.save(existingarea);
        return tipoSubAreaMapper.toResponseDto(updatearea);
    }

    public void deleteById(Long id) {
        if (!tipoSubAreaRepository.existsById(id)) {
            throw new RuntimeException("Area no encontrado con id: " + id);
        }
        tipoSubAreaRepository.deleteById(id);
    }
}