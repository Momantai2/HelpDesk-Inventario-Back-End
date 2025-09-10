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
    public ResponseEntity<ProvinciaResponseDTO> crearProvincia(@RequestBody ProvinciaRequestDTO provinciaRequestDTO) {
        ProvinciaResponseDTO nuevoprovincia = provinciaService.save(provinciaRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoprovincia);
    }

    // Obtener provincia por ID
    @GetMapping("/{id}")
    public ResponseEntity<ProvinciaResponseDTO> obtenerProvinciaPorId(@PathVariable Long id) {
        ProvinciaResponseDTO provincia = provinciaService.findById(id);
        return ResponseEntity.ok(provincia);
    }

    // Listar todos los provincias
    @GetMapping
    public ResponseEntity<List<ProvinciaResponseDTO>> listarProvincias() {
        List<ProvinciaResponseDTO> provincias = provinciaService.findAll();
        return ResponseEntity.ok(provincias);
    }

    // Actualizar provincia
    @PutMapping("/{id}")
    public ResponseEntity<ProvinciaResponseDTO> actualizarProvincia(@PathVariable Long id,
        @RequestBody ProvinciaRequestDTO provinciaRequestDTO) {
        ProvinciaResponseDTO provinciaActualizado = provinciaService.update(id, provinciaRequestDTO);
        return ResponseEntity.ok(provinciaActualizado);
    }

    // Eliminar provincia
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProvincia(@PathVariable Long id) {
        provinciaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
      @PostMapping("/lote")
public ResponseEntity<List<ProvinciaResponseDTO>> crearProvincias(@RequestBody List<ProvinciaRequestDTO> provincias) {
    List<ProvinciaResponseDTO> nuevos = provinciaService.saveAll(provincias);
    return ResponseEntity.status(HttpStatus.CREATED).body(nuevos);
}

}
