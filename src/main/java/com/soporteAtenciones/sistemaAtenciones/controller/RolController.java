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

import com.soporteAtenciones.sistemaAtenciones.dtos.tickets.RolRequestDTO;
import com.soporteAtenciones.sistemaAtenciones.dtos.tickets.RolResponseDTO;
import com.soporteAtenciones.sistemaAtenciones.service.RolService;

@RestController
@RequestMapping("/api/roles")
@CrossOrigin(origins = "http://localhost:4200")
public class RolController {

    private final RolService rolService;

    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    // Crear rol
    @PostMapping
    public ResponseEntity<RolResponseDTO> crearRol(@RequestBody RolRequestDTO rolRequestDTO) {
        RolResponseDTO nuevoRol = rolService.crearRol(rolRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoRol);
    }

    // Obtener rol por ID
    @GetMapping("/{id}")
    public ResponseEntity<RolResponseDTO> obtenerRolPorId(@PathVariable Long id) {
        RolResponseDTO rol = rolService.findById(id);
        return ResponseEntity.ok(rol);
    }

    // Listar todos los roles
    @GetMapping
    public ResponseEntity<List<RolResponseDTO>> listarRoles() {
        List<RolResponseDTO> roles = rolService.findAll();
        return ResponseEntity.ok(roles);
    }

    // Actualizar rol
    @PutMapping("/{id}")
    public ResponseEntity<RolResponseDTO> actualizarRol(@PathVariable Long id,
                                                        @RequestBody RolRequestDTO rolRequestDTO) {
        RolResponseDTO rolActualizado = rolService.update(id, rolRequestDTO);
        return ResponseEntity.ok(rolActualizado);
    }

    // Eliminar rol
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarRol(@PathVariable Long id) {
        rolService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
