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

import com.soporteAtenciones.sistemaAtenciones.dtos.inventario.TipoSubAreaRequest;
import com.soporteAtenciones.sistemaAtenciones.dtos.inventario.TipoSubAreaResponse;
import com.soporteAtenciones.sistemaAtenciones.service.inventario.TipoSubAreaService;




@RestController
@RequestMapping("/api/tipo-subArea")
@CrossOrigin(origins = "http://localhost:4200")
public class TipoSubAreaController {

  private final TipoSubAreaService tiposubareaService;

    public TipoSubAreaController(TipoSubAreaService tiposubareaService) {
        this.tiposubareaService = tiposubareaService;
    }

    // Crear Tiposubarea
    @PostMapping
    public ResponseEntity<TipoSubAreaResponse> crearTiposubarea(@RequestBody TipoSubAreaRequest tipoSubAreaRequest) {
        TipoSubAreaResponse nuevotiposubarea = tiposubareaService.save(tipoSubAreaRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevotiposubarea);
    }

    // Obtener Tiposubarea por ID
    @GetMapping("/{id}")
    public ResponseEntity<TipoSubAreaResponse> obtenerTiposubareaPorId(@PathVariable Long id) {
        TipoSubAreaResponse tiposubarea = tiposubareaService.findById(id);
        return ResponseEntity.ok(tiposubarea);
    }

    // Listar todos los Tiposubareas
     @GetMapping
    public ResponseEntity<List<TipoSubAreaResponse>> listartiposubarea() {
        List<TipoSubAreaResponse> tiposucursals = tiposubareaService.findAll();
        return ResponseEntity.ok(tiposucursals);
    }


    // Actualizar Tiposubareas
    @PutMapping("/{id}")
    public ResponseEntity<TipoSubAreaResponse> actualizarTiposubarea(@PathVariable Long id,
        @RequestBody TipoSubAreaRequest tipoSubAreaRequest) {
        TipoSubAreaResponse tiposubareaActualizado = tiposubareaService.update(id, tipoSubAreaRequest);
        return ResponseEntity.ok(tiposubareaActualizado);
    }

    // Eliminar Tiposubarea
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTiposubarea(@PathVariable Long id) {
        tiposubareaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
