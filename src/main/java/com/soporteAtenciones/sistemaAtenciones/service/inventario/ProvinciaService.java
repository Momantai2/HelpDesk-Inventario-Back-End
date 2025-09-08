package com.soporteAtenciones.sistemaAtenciones.service.inventario;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.soporteAtenciones.sistemaAtenciones.dtos.inventario.ProvinciaRequestDTO;
import com.soporteAtenciones.sistemaAtenciones.dtos.inventario.ProvinciaResponseDTO;
import com.soporteAtenciones.sistemaAtenciones.exception.DuplicateResourceException;
import com.soporteAtenciones.sistemaAtenciones.exception.ResourceNotFoundException;
import com.soporteAtenciones.sistemaAtenciones.mappers.ProvinciaMapper;
import com.soporteAtenciones.sistemaAtenciones.models.inventario.Departamento;
import com.soporteAtenciones.sistemaAtenciones.models.inventario.Provincia;
import com.soporteAtenciones.sistemaAtenciones.repository.inventario.DepartamentoRepository;
import com.soporteAtenciones.sistemaAtenciones.repository.inventario.ProvinciaRepository;

@Service
public class ProvinciaService {

    private final ProvinciaRepository provinciaRepository;
    private final DepartamentoRepository departamentoRepository;
    private final ProvinciaMapper provinciaMapper;

    public ProvinciaService(ProvinciaRepository provinciaRepository,
                            DepartamentoRepository departamentoRepository,
                            ProvinciaMapper provinciaMapper) {
        this.provinciaRepository = provinciaRepository;
        this.departamentoRepository = departamentoRepository;
        this.provinciaMapper = provinciaMapper;
    }

    @Transactional
    public ProvinciaResponseDTO crearProvincia(ProvinciaRequestDTO request) {
        if (provinciaRepository.existsByNombre(request.getNombre())) {
            throw new DuplicateResourceException("Provincia", "nombre", request.getNombre());
        }

        // Validar departamento
        Departamento departamento = departamentoRepository.findById(request.getDepartamentoId())
                .orElseThrow(() -> new ResourceNotFoundException("Departamento", "id", request.getDepartamentoId()));

        Provincia provincia = provinciaMapper.toEntity(request);
        provincia.setDepartamento(departamento);

        return provinciaMapper.toResponseDTO(provinciaRepository.save(provincia));
    }

    public ProvinciaResponseDTO obtenerProvinciaPorId(Long id) {
        Provincia provincia = provinciaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Provincia", "id", id));

        return provinciaMapper.toResponseDTO(provincia);
    }

    public List<ProvinciaResponseDTO> listarProvincias() {
        return provinciaRepository.findAll()
                .stream()
                .map(provinciaMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public ProvinciaResponseDTO actualizarProvincia(Long id, ProvinciaRequestDTO request) {
        Provincia existente = provinciaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Provincia", "id", id));

        // Validar duplicados en nombre
        if (!existente.getNombre().equalsIgnoreCase(request.getNombre())
                && provinciaRepository.existsByNombre(request.getNombre())) {
            throw new DuplicateResourceException("Provincia", "nombre", request.getNombre());
        }

        // Validar departamento
        Departamento departamento = departamentoRepository.findById(request.getDepartamentoId())
                .orElseThrow(() -> new ResourceNotFoundException("Departamento", "id", request.getDepartamentoId()));

        existente.setNombre(request.getNombre());
        existente.setDepartamento(departamento);

        return provinciaMapper.toResponseDTO(provinciaRepository.save(existente));
    }

    @Transactional
    public void eliminarProvincia(Long id) {
        Provincia existente = provinciaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Provincia", "id", id));

        provinciaRepository.delete(existente);
    }
}
