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

import com.soporteAtenciones.sistemaAtenciones.models.Rol;
import com.soporteAtenciones.sistemaAtenciones.service.RolService;


@RestController
@RequestMapping("/api/roles")
@CrossOrigin(origins = "http://localhost:4200")
public class RolController {

  private final RolService rolService;

    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    // Crear ticket
    @PostMapping
    public ResponseEntity<Rol> crearRol(@RequestBody Rol usuario) {
        Rol nuevoRol = rolService.crearRol(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoRol);
    }

    // Obtener usuario por ID
    @GetMapping("/{id}")
    public ResponseEntity<Rol> obtenerRolPorId(@PathVariable Long id) {
        Rol usuario = rolService.obtenerRolPorId(id);
        return ResponseEntity.ok(usuario);
    }

    // Listar todos los ticket
    @GetMapping
    public ResponseEntity<List<Rol>> listarRols() {
        return ResponseEntity.ok(rolService.listarRoles());
    }

    // Actualizar ticket
    @PutMapping("/{id}")
    public ResponseEntity<Rol> actualizarRol(@PathVariable Long id, @RequestBody Rol usuario) {
        Rol usuarioActualizado = rolService.actualizarRol(id, usuario);
        return ResponseEntity.ok(usuarioActualizado);
    }

    // Eliminar ticket
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarRol(@PathVariable Long id) {
        rolService.eliminarRol(id);
        return ResponseEntity.noContent().build();
    }
}