package com.soporteAtenciones.sistemaAtenciones.service.inventario;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.soporteAtenciones.sistemaAtenciones.dtos.inventario.SucursalRequestDTO;
import com.soporteAtenciones.sistemaAtenciones.dtos.inventario.SucursalResponseDTO;
import com.soporteAtenciones.sistemaAtenciones.mappers.SucursalMapper;
import com.soporteAtenciones.sistemaAtenciones.models.inventario.Sucursal;
import com.soporteAtenciones.sistemaAtenciones.repository.inventario.SucursalRepository;

@Service
public class SucursalService {

 private final SucursalRepository sucursalRepository;
    private final SucursalMapper sucursalMapper;

    
    public SucursalService(SucursalRepository sucursalRepository, SucursalMapper sucursalMapper) {
        this.sucursalRepository = sucursalRepository;
        this.sucursalMapper = sucursalMapper;
    }

    public List<SucursalResponseDTO> findAll() {
        return sucursalRepository.findAll().stream()
                .map(sucursalMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    public SucursalResponseDTO findById(Long id) {
        Sucursal sucursal = sucursalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sucursal no encontrado con id: " + id));
        return sucursalMapper.toResponseDto(sucursal);
    }
    
    public List<SucursalResponseDTO> saveAll(List<SucursalRequestDTO> sucursalRequestDTOList) {
    List<Sucursal> sucursals = sucursalRequestDTOList.stream()
            .map(sucursalMapper::toEntity)
            .collect(Collectors.toList());

    List<Sucursal> guardados = sucursalRepository.saveAll(sucursals);

    return guardados.stream()
            .map(sucursalMapper::toResponseDto)
            .collect(Collectors.toList());
}

 

    public SucursalResponseDTO save(SucursalRequestDTO sucursalRequestDTO) {
        // Validación o lógica de negocio antes de guardar
        Sucursal sucursal = sucursalMapper.toEntity(sucursalRequestDTO);
        Sucursal savedsucursal = sucursalRepository.save(sucursal);
        return sucursalMapper.toResponseDto(savedsucursal);
    }

    public SucursalResponseDTO update(Long id, SucursalRequestDTO sucursalRequestDTO) {
        Sucursal existingsucursal = sucursalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sucursal no encontrado con id: " + id));
        
        sucursalMapper.updateEntityFromDto(sucursalRequestDTO, existingsucursal);
        Sucursal updatesucursal = sucursalRepository.save(existingsucursal);
        return sucursalMapper.toResponseDto(updatesucursal);
    }

    public void deleteById(Long id) {
        if (!sucursalRepository.existsById(id)) {
            throw new RuntimeException("Sucursal no encontrado con id: " + id);
        }
        sucursalRepository.deleteById(id);
    }
}