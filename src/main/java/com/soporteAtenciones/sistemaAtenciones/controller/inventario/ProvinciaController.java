package com.soporteAtenciones.sistemaAtenciones.controller.inventario;

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

import com.soporteAtenciones.sistemaAtenciones.dtos.inventario.ProvinciaRequestDTO;
import com.soporteAtenciones.sistemaAtenciones.dtos.inventario.ProvinciaResponseDTO;
import com.soporteAtenciones.sistemaAtenciones.service.inventario.ProvinciaService;

@RestController
@RequestMapping("api/provincias")
@CrossOrigin(origins = "http://localhost:4200")
public class ProvinciaController {

  private final ProvinciaService provinciaService;

    public ProvinciaController(ProvinciaService provinciaService) {
        this.provinciaService = provinciaService;
    }

    // Crear Provincia
    @PostMapping
    public ResponseEntity<ProvinciaResponseDTO> crearProvincia(@RequestBody ProvinciaRequestDTO requestDTO) {
        ProvinciaResponseDTO nuevaProvincia = provinciaService.crearProvincia(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaProvincia);
    }

    // Obtener Provincia por ID
    @GetMapping("/{id}")
    public ResponseEntity<ProvinciaResponseDTO> obtenerProvinciaPorId(@PathVariable Long id) {
        ProvinciaResponseDTO provincia = provinciaService.obtenerProvinciaPorId(id);
        return ResponseEntity.ok(provincia);
    }

    // Listar todas las Provincias
    @GetMapping
    public ResponseEntity<List<ProvinciaResponseDTO>> listarProvincias() {
        return ResponseEntity.ok(provinciaService.listarProvincias());
    }

    // Actualizar Provincia
    @PutMapping("/{id}")
    public ResponseEntity<ProvinciaResponseDTO> actualizarProvincia(@PathVariable Long id,
                                                                    @RequestBody ProvinciaRequestDTO requestDTO) {
        ProvinciaResponseDTO provinciaActualizada = provinciaService.actualizarProvincia(id, requestDTO);
        return ResponseEntity.ok(provinciaActualizada);
    }

    // Eliminar Provincia
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProvincia(@PathVariable Long id) {
        provinciaService.eliminarProvincia(id);
        return ResponseEntity.noContent().build();
    }
}