package com.soporteAtenciones.sistemaAtenciones.service.inventario;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.soporteAtenciones.sistemaAtenciones.dtos.inventario.TipoSucursalRequestDTO;
import com.soporteAtenciones.sistemaAtenciones.dtos.inventario.TipoSucursalResponseDTO;
import com.soporteAtenciones.sistemaAtenciones.mappers.TipoSucursalMapper;
import com.soporteAtenciones.sistemaAtenciones.models.inventario.TipoSucursal;
import com.soporteAtenciones.sistemaAtenciones.repository.inventario.TipoSucursalRepository;

@Service
public class TipoSucursalService {

 private final TipoSucursalRepository tiposucursalRepository;
    private final TipoSucursalMapper tiposucursalMapper;

    
    public TipoSucursalService(TipoSucursalRepository tiposucursalRepository, TipoSucursalMapper tiposucursalMapper) {
        this.tiposucursalRepository = tiposucursalRepository;
        this.tiposucursalMapper = tiposucursalMapper;
    }

    public List<TipoSucursalResponseDTO> findAll() {
        return tiposucursalRepository.findAll().stream()
                .map(tiposucursalMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    public TipoSucursalResponseDTO findById(Long id) {
        TipoSucursal tiposucursal = tiposucursalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TipoSucursal no encontrado con id: " + id));
        return tiposucursalMapper.toResponseDto(tiposucursal);
    }
    
    public List<TipoSucursalResponseDTO> saveAll(List<TipoSucursalRequestDTO> tiposucursalRequestDTOList) {
    List<TipoSucursal> tiposucursals = tiposucursalRequestDTOList.stream()
            .map(tiposucursalMapper::toEntity)
            .collect(Collectors.toList());

    List<TipoSucursal> guardados = tiposucursalRepository.saveAll(tiposucursals);

    return guardados.stream()
            .map(tiposucursalMapper::toResponseDto)
            .collect(Collectors.toList());
}

 

    public TipoSucursalResponseDTO save(TipoSucursalRequestDTO tiposucursalRequestDTO) {
        // Validación o lógica de negocio antes de guardar
        TipoSucursal tiposucursal = tiposucursalMapper.toEntity(tiposucursalRequestDTO);
        TipoSucursal savedtiposucursal = tiposucursalRepository.save(tiposucursal);
        return tiposucursalMapper.toResponseDto(savedtiposucursal);
    }

    public TipoSucursalResponseDTO update(Long id, TipoSucursalRequestDTO tiposucursalRequestDTO) {
        TipoSucursal existingtiposucursal = tiposucursalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TipoSucursal no encontrado con id: " + id));
        
        tiposucursalMapper.updateEntityFromDto(tiposucursalRequestDTO, existingtiposucursal);
        TipoSucursal updatetiposucursal = tiposucursalRepository.save(existingtiposucursal);
        return tiposucursalMapper.toResponseDto(updatetiposucursal);
    }

    public void deleteById(Long id) {
        if (!tiposucursalRepository.existsById(id)) {
            throw new RuntimeException("TipoSucursal no encontrado con id: " + id);
        }
        tiposucursalRepository.deleteById(id);
    }
}