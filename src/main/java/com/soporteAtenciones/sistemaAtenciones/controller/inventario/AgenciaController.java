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

import com.soporteAtenciones.sistemaAtenciones.dtos.inventario.AgenciaRequestDTO;
import com.soporteAtenciones.sistemaAtenciones.dtos.inventario.AgenciaResponseDTO;
import com.soporteAtenciones.sistemaAtenciones.service.inventario.AgenciaService;

@RestController
@RequestMapping("api/agencias")
@CrossOrigin(origins = "http://localhost:4200")
public class AgenciaController {
   private final AgenciaService agenciaService;

    public AgenciaController(AgenciaService agenciaService) {
        this.agenciaService = agenciaService;
    }

    // Crear Agencia
    @PostMapping
    public ResponseEntity<AgenciaResponseDTO> crearAgencia(@RequestBody AgenciaRequestDTO agenciaRequestDTO) {
        AgenciaResponseDTO nuevoagencia = agenciaService.save(agenciaRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoagencia);
    }

    // Obtener agencia por ID
    @GetMapping("/{id}")
    public ResponseEntity<AgenciaResponseDTO> obtenerAgenciaPorId(@PathVariable Long id) {
        AgenciaResponseDTO agencia = agenciaService.findById(id);
        return ResponseEntity.ok(agencia);
    }

    // Listar todos los agencias
    @GetMapping
    public ResponseEntity<List<AgenciaResponseDTO>> listarAgencias() {
        List<AgenciaResponseDTO> agencias = agenciaService.findAll();
        return ResponseEntity.ok(agencias);
    }

    // Actualizar agencia
    @PutMapping("/{id}")
    public ResponseEntity<AgenciaResponseDTO> actualizarAgencia(@PathVariable Long id,
        @RequestBody AgenciaRequestDTO agenciaRequestDTO) {
        AgenciaResponseDTO agenciaActualizado = agenciaService.update(id, agenciaRequestDTO);
        return ResponseEntity.ok(agenciaActualizado);
    }

    // Eliminar agencia
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAgencia(@PathVariable Long id) {
        agenciaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/lote")
public ResponseEntity<List<AgenciaResponseDTO>> crearAgencias(@RequestBody List<AgenciaRequestDTO> agencias) {
    List<AgenciaResponseDTO> nuevos = agenciaService.saveAll(agencias);
    return ResponseEntity.status(HttpStatus.CREATED).body(nuevos);
}


}
