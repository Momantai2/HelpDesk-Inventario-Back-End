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

import com.soporteAtenciones.sistemaAtenciones.models.Comentario;
import com.soporteAtenciones.sistemaAtenciones.service.ComentarioService;

@RestController
@RequestMapping("/api/comentarios")
@CrossOrigin(origins = "http://localhost:4200")
public class ComentarioController {


  private final ComentarioService comentarioService;

    public ComentarioController(ComentarioService comentarioService) {
        this.comentarioService = comentarioService;
    }

    // Crear ticket
    @PostMapping
    public ResponseEntity<Comentario> crearComentario(@RequestBody Comentario usuario) {
        Comentario nuevoComentario = comentarioService.crearComentario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoComentario);
    }

    // Obtener usuario por ID
    @GetMapping("/{id}")
    public ResponseEntity<Comentario> obtenerComentarioPorId(@PathVariable Long id) {
        Comentario usuario = comentarioService.obtenerComentarioPorId(id);
        return ResponseEntity.ok(usuario);
    }

    // Listar todos los ticket
      @GetMapping
    public ResponseEntity<List<Comentario>> listarComentario(
        @RequestParam(required = false) Long ticket) {
        if (ticket != null) {
            return ResponseEntity.ok(comentarioService.listarComentariosPorTicket(ticket));
        } else {
            return ResponseEntity.ok(comentarioService.listarComentarios());
        }
    }

    // Actualizar ticket
    @PutMapping("/{id}")
    public ResponseEntity<Comentario> actualizarComentario(@PathVariable Long id, @RequestBody Comentario usuario) {
        Comentario usuarioActualizado = comentarioService.actualizarComentario(id, usuario);
        return ResponseEntity.ok(usuarioActualizado);
    }

    // Eliminar ticket
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarComentario(@PathVariable Long id) {
        comentarioService.eliminarComentario(id);
        return ResponseEntity.noContent().build();
    }
}   