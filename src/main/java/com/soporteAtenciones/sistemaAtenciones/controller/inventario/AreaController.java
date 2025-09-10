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

import com.soporteAtenciones.sistemaAtenciones.dtos.inventario.AreaRequestDTO;
import com.soporteAtenciones.sistemaAtenciones.dtos.inventario.AreaResponseDTO;
import com.soporteAtenciones.sistemaAtenciones.service.inventario.AreaService;



@RestController
@RequestMapping("/api/areas")
@CrossOrigin(origins = "http://localhost:4200")
public class AreaController {

  private final AreaService areaService;

    public AreaController(AreaService areaService) {
        this.areaService = areaService;
    }

    // Crear Area
    @PostMapping
    public ResponseEntity<AreaResponseDTO> crearArea(@RequestBody AreaRequestDTO areaRequestDTO) {
        AreaResponseDTO nuevoarea = areaService.save(areaRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoarea);
    }

    // Obtener Area por ID
    @GetMapping("/{id}")
    public ResponseEntity<AreaResponseDTO> obtenerAreaPorId(@PathVariable Long id) {
        AreaResponseDTO area = areaService.findById(id);
        return ResponseEntity.ok(area);
    }

    // Listar todos los Areas
    @GetMapping
    public ResponseEntity<List<AreaResponseDTO>> listarAreas() {
        List<AreaResponseDTO> areas = areaService.findAll();
        return ResponseEntity.ok(areas);
    }

    // Actualizar Areas
    @PutMapping("/{id}")
    public ResponseEntity<AreaResponseDTO> actualizarArea(@PathVariable Long id,
        @RequestBody AreaRequestDTO areaRequestDTO) {
        AreaResponseDTO areaActualizado = areaService.update(id, areaRequestDTO);
        return ResponseEntity.ok(areaActualizado);
    }

    // Eliminar Area
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarArea(@PathVariable Long id) {
        areaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
