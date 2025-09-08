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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.soporteAtenciones.sistemaAtenciones.dtos.tickets.ComentarioRequestDTO;
import com.soporteAtenciones.sistemaAtenciones.dtos.tickets.ComentarioResponseDTO;
import com.soporteAtenciones.sistemaAtenciones.service.ComentarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/comentarios")
@CrossOrigin(origins = "http://localhost:4200")
public class ComentarioController {

    private final ComentarioService comentarioService;

    public ComentarioController(ComentarioService comentarioService) {
        this.comentarioService = comentarioService;
    }

    @PostMapping
    public ResponseEntity<ComentarioResponseDTO> crearComentario(@Valid @RequestBody ComentarioRequestDTO request) {
        ComentarioResponseDTO nuevoComentario = comentarioService.crearComentario(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoComentario);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComentarioResponseDTO> obtenerComentarioPorId(@PathVariable Long id) {
        ComentarioResponseDTO comentario = comentarioService.obtenerComentarioPorId(id);
        return ResponseEntity.ok(comentario);
    }

   // ComentarioController.java

@GetMapping
public ResponseEntity<List<ComentarioResponseDTO>> listarComentariosPorTicket(
        @RequestParam(required = false) Long ticketId) {
    if (ticketId != null) {
        List<ComentarioResponseDTO> comentarios = comentarioService.listarComentariosPorTicket(ticketId);
        return ResponseEntity.ok(comentarios);
    } else {
        // Si no se proporciona ticketId, devuelve todos los comentarios.
        List<ComentarioResponseDTO> comentarios = comentarioService.listarTodosLosComentarios();
        return ResponseEntity.ok(comentarios);
    }
}

    @PutMapping("/{id}")
    public ResponseEntity<ComentarioResponseDTO> actualizarComentario(
            @PathVariable Long id,
            @Valid @RequestBody ComentarioRequestDTO request) {
        ComentarioResponseDTO comentarioActualizado = comentarioService.actualizarComentario(id, request);
        return ResponseEntity.ok(comentarioActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarComentario(@PathVariable Long id) {
        comentarioService.eliminarComentario(id);
        return ResponseEntity.noContent().build();
    }
}