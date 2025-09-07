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

import com.soporteAtenciones.sistemaAtenciones.models.Prioridad;
import com.soporteAtenciones.sistemaAtenciones.service.PrioridadService;


@RestController
@RequestMapping("/api/prioridades")
@CrossOrigin(origins = "http://localhost:4200")
public class PrioridadController {

  private final PrioridadService prioridadService;

    public PrioridadController(PrioridadService prioridadService) {
        this.prioridadService = prioridadService;
    }

    // Crear ticket
    @PostMapping
    public ResponseEntity<Prioridad> crearPrioridad(@RequestBody Prioridad usuario) {
        Prioridad nuevoPrioridad = prioridadService.crearPrioridad(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoPrioridad);
    }

    // Obtener usuario por ID
    @GetMapping("/{id}")
    public ResponseEntity<Prioridad> obtenerPrioridadPorId(@PathVariable Long id) {
        Prioridad usuario = prioridadService.obtenerPrioridadPorId(id);
        return ResponseEntity.ok(usuario);
    }

    // Listar todos los ticket
    @GetMapping
    public ResponseEntity<List<Prioridad>> listarPrioridad() {
        return ResponseEntity.ok(prioridadService.listarPrioridades());
    }

    // Actualizar ticket
    @PutMapping("/{id}")
    public ResponseEntity<Prioridad> actualizarPrioridad(@PathVariable Long id, @RequestBody Prioridad usuario) {
        Prioridad usuarioActualizado = prioridadService.actualizarPrioridad(id, usuario);
        return ResponseEntity.ok(usuarioActualizado);
    }

    // Eliminar ticket
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPrioridad(@PathVariable Long id) {
        prioridadService.eliminarPrioridad(id);
        return ResponseEntity.noContent().build();
    }
}