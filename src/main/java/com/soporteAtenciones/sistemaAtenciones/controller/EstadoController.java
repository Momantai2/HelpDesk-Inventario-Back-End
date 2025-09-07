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

import com.soporteAtenciones.sistemaAtenciones.models.Estado;
import com.soporteAtenciones.sistemaAtenciones.service.EstadoService;

@RestController
@RequestMapping("/api/estados")
@CrossOrigin(origins = "http://localhost:4200")
public class EstadoController {

  private final EstadoService estadoService;

    public EstadoController(EstadoService estadoService) {
        this.estadoService = estadoService;
    }

    // Crear ticket
    @PostMapping
    public ResponseEntity<Estado> crearEstado(@RequestBody Estado usuario) {
        Estado nuevoEstado = estadoService.crearEstado(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoEstado);
    }

    // Obtener usuario por ID
    @GetMapping("/{id}")
    public ResponseEntity<Estado> obtenerEstadoPorId(@PathVariable Long id) {
        Estado usuario = estadoService.obtenerEstadoPorId(id);
        return ResponseEntity.ok(usuario);
    }

    // Listar todos los ticket
    @GetMapping
    public ResponseEntity<List<Estado>> listarEstado() {
        return ResponseEntity.ok(estadoService.listarEstados());
    }

    // Actualizar ticket
    @PutMapping("/{id}")
    public ResponseEntity<Estado> actualizarEstado(@PathVariable Long id, @RequestBody Estado usuario) {
        Estado usuarioActualizado = estadoService.actualizarEstado(id, usuario);
        return ResponseEntity.ok(usuarioActualizado);
    }

    // Eliminar ticket
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEstado(@PathVariable Long id) {
        estadoService.eliminarEstado(id);
        return ResponseEntity.noContent().build();
    }
}   