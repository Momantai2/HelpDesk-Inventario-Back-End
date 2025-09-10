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

import com.soporteAtenciones.sistemaAtenciones.dtos.inventario.DistritoRequestDTO;
import com.soporteAtenciones.sistemaAtenciones.dtos.inventario.DistritoResponseDTO;
import com.soporteAtenciones.sistemaAtenciones.service.inventario.DistritoService;
@RestController
@RequestMapping("api/distritos")
@CrossOrigin(origins = "http://localhost:4200")
public class DistritoController {


   private final DistritoService distritoService;

    public DistritoController(DistritoService distritoService) {
        this.distritoService = distritoService;
    }

    // Crear Distrito
    @PostMapping
    public ResponseEntity<DistritoResponseDTO> crearDistrito(@RequestBody DistritoRequestDTO distritoRequestDTO) {
        DistritoResponseDTO nuevodistrito = distritoService.save(distritoRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevodistrito);
    }

    // Obtener distrito por ID
    @GetMapping("/{id}")
    public ResponseEntity<DistritoResponseDTO> obtenerDistritoPorId(@PathVariable Long id) {
        DistritoResponseDTO distrito = distritoService.findById(id);
        return ResponseEntity.ok(distrito);
    }

    // Listar todos los distritos
    @GetMapping
    public ResponseEntity<List<DistritoResponseDTO>> listarDistritos() {
        List<DistritoResponseDTO> distritos = distritoService.findAll();
        return ResponseEntity.ok(distritos);
    }

    // Actualizar distrito
    @PutMapping("/{id}")
    public ResponseEntity<DistritoResponseDTO> actualizarDistrito(@PathVariable Long id,
        @RequestBody DistritoRequestDTO distritoRequestDTO) {
        DistritoResponseDTO distritoActualizado = distritoService.update(id, distritoRequestDTO);
        return ResponseEntity.ok(distritoActualizado);
    }

    // Eliminar distrito
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarDistrito(@PathVariable Long id) {
        distritoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

       @PostMapping("/lote")
public ResponseEntity<List<DistritoResponseDTO>> crearDistritos(@RequestBody List<DistritoRequestDTO> distritos) {
    List<DistritoResponseDTO> nuevos = distritoService.saveAll(distritos);
    return ResponseEntity.status(HttpStatus.CREATED).body(nuevos);
}


}
