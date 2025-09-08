package com.soporteAtenciones.sistemaAtenciones.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soporteAtenciones.sistemaAtenciones.dtos.tickets.PrioridadRequestDTO;
import com.soporteAtenciones.sistemaAtenciones.dtos.tickets.PrioridadResponseDTO;
import com.soporteAtenciones.sistemaAtenciones.service.PrioridadService;


@RestController
@RequestMapping("/api/prioridades")
@CrossOrigin(origins = "http://localhost:4200")
public class PrioridadController {

    private final PrioridadService prioridadService;

    public PrioridadController(PrioridadService prioridadService) {
        this.prioridadService = prioridadService;
    }

    // Crear Prioridad
    @PostMapping
    public ResponseEntity<PrioridadResponseDTO> crearPrioridad(@RequestBody PrioridadRequestDTO prioridadRequestDTO) {
        PrioridadResponseDTO nuevaprioridad = prioridadService.save(prioridadRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaprioridad);
    }

    // Obtener Prioridad por ID
    @GetMapping("/{id}")
    public ResponseEntity<PrioridadResponseDTO> obtenerPrioridadPorId(@PathVariable Long id) {
        PrioridadResponseDTO prioridad = prioridadService.findById(id);
        return ResponseEntity.ok(prioridad);
    }

    // Listar todos los Prioridades
    @GetMapping
    public ResponseEntity<List<PrioridadResponseDTO>> listarPrioridades() {
        List<PrioridadResponseDTO> prioridades = prioridadService.findAll();
        return ResponseEntity.ok(prioridades);
    }

    // Actualizar Prioridad
    @PutMapping("/{id}")
    public ResponseEntity<PrioridadResponseDTO> actualizarPrioridad(@PathVariable Long id,
        @RequestBody PrioridadRequestDTO prioridadRequestDTO) {
        PrioridadResponseDTO prioridadActualizado = prioridadService.update(id, prioridadRequestDTO);
        return ResponseEntity.ok(prioridadActualizado);
    }

    // Eliminar Prioridad
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPrioridad(@PathVariable Long id) {
        prioridadService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
