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

import com.soporteAtenciones.sistemaAtenciones.dtos.tickets.EstadoRequestDTO;
import com.soporteAtenciones.sistemaAtenciones.dtos.tickets.EstadoResponseDTO;
import com.soporteAtenciones.sistemaAtenciones.service.EstadoService;

@RestController
@RequestMapping("/api/estados")
@CrossOrigin(origins = "http://localhost:4200")
public class EstadoController {

   private final EstadoService estadoService;

    public EstadoController(EstadoService estadoService) {
        this.estadoService = estadoService;
    }

    // Crear Estado
    @PostMapping
    public ResponseEntity<EstadoResponseDTO> crearEstado(@RequestBody EstadoRequestDTO estadoRequestDTO) {
        EstadoResponseDTO nuevoestado = estadoService.save(estadoRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoestado);
    }

    // Obtener Estado por ID
    @GetMapping("/{id}")
    public ResponseEntity<EstadoResponseDTO> obtenerEstadoPorId(@PathVariable Long id) {
        EstadoResponseDTO estado = estadoService.findById(id);
        return ResponseEntity.ok(estado);
    }

    // Listar todos los Estados
    @GetMapping
    public ResponseEntity<List<EstadoResponseDTO>> listarEstados() {
        List<EstadoResponseDTO> estados = estadoService.findAll();
        return ResponseEntity.ok(estados);
    }

    // Actualizar Estados
    @PutMapping("/{id}")
    public ResponseEntity<EstadoResponseDTO> actualizarEstado(@PathVariable Long id,
        @RequestBody EstadoRequestDTO estadoRequestDTO) {
        EstadoResponseDTO estadoActualizado = estadoService.update(id, estadoRequestDTO);
        return ResponseEntity.ok(estadoActualizado);
    }

    // Eliminar Estado
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEstado(@PathVariable Long id) {
        estadoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
