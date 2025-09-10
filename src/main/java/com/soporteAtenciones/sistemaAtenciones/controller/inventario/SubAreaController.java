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

import com.soporteAtenciones.sistemaAtenciones.dtos.inventario.SubAreaRequestDTO;
import com.soporteAtenciones.sistemaAtenciones.dtos.inventario.SubAreaResponseDTO;
import com.soporteAtenciones.sistemaAtenciones.service.inventario.SubAreaService;




@RestController
@RequestMapping("/api/subareas")
@CrossOrigin(origins = "http://localhost:4200")
public class SubAreaController {

   private final SubAreaService subareaService;

    public SubAreaController(SubAreaService subareaService) {
        this.subareaService = subareaService;
    }

    // Crear SubArea
    @PostMapping
    public ResponseEntity<SubAreaResponseDTO> crearSubArea(@RequestBody SubAreaRequestDTO subareaRequestDTO) {
        SubAreaResponseDTO nuevosubarea = subareaService.save(subareaRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevosubarea);
    }

    // Obtener SubArea por ID
    @GetMapping("/{id}")
    public ResponseEntity<SubAreaResponseDTO> obtenerSubAreaPorId(@PathVariable Long id) {
        SubAreaResponseDTO subarea = subareaService.findById(id);
        return ResponseEntity.ok(subarea);
    }

    // Listar todos los SubAreas
    @GetMapping
    public ResponseEntity<List<SubAreaResponseDTO>> listarSubAreas() {
        List<SubAreaResponseDTO> subareas = subareaService.findAll();
        return ResponseEntity.ok(subareas);
    }

    // Actualizar SubAreas
    @PutMapping("/{id}")
    public ResponseEntity<SubAreaResponseDTO> actualizarSubArea(@PathVariable Long id,
        @RequestBody SubAreaRequestDTO subareaRequestDTO) {
        SubAreaResponseDTO subareaActualizado = subareaService.update(id, subareaRequestDTO);
        return ResponseEntity.ok(subareaActualizado);
    }

    // Eliminar SubArea
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarSubArea(@PathVariable Long id) {
        subareaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
