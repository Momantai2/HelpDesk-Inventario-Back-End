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

import com.soporteAtenciones.sistemaAtenciones.dtos.inventario.TipoSucursalRequestDTO;
import com.soporteAtenciones.sistemaAtenciones.dtos.inventario.TipoSucursalResponseDTO;
import com.soporteAtenciones.sistemaAtenciones.service.inventario.TipoSucursalService;



@RestController
@RequestMapping("/api/tipos-sucursal")
@CrossOrigin(origins = "http://localhost:4200")
public class TipoSucursalController {


  private final TipoSucursalService tiposucursalService;

    public TipoSucursalController(TipoSucursalService tiposucursalService) {
        this.tiposucursalService = tiposucursalService;
    }

    // Crear TipoSucursal
    @PostMapping
    public ResponseEntity<TipoSucursalResponseDTO> crearTipoSucursal(@RequestBody TipoSucursalRequestDTO tiposucursalRequestDTO) {
        TipoSucursalResponseDTO nuevotiposucursal = tiposucursalService.save(tiposucursalRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevotiposucursal);
    }

    // Obtener TipoSucursal por ID
    @GetMapping("/{id}")
    public ResponseEntity<TipoSucursalResponseDTO> obtenerTipoSucursalPorId(@PathVariable Long id) {
        TipoSucursalResponseDTO tiposucursal = tiposucursalService.findById(id);
        return ResponseEntity.ok(tiposucursal);
    }

    // Listar todos los TipoSucursals
    @GetMapping
    public ResponseEntity<List<TipoSucursalResponseDTO>> listarTipoSucursals() {
        List<TipoSucursalResponseDTO> tiposucursals = tiposucursalService.findAll();
        return ResponseEntity.ok(tiposucursals);
    }

    // Actualizar TipoSucursals
    @PutMapping("/{id}")
    public ResponseEntity<TipoSucursalResponseDTO> actualizarTipoSucursal(@PathVariable Long id,
        @RequestBody TipoSucursalRequestDTO tiposucursalRequestDTO) {
        TipoSucursalResponseDTO tiposucursalActualizado = tiposucursalService.update(id, tiposucursalRequestDTO);
        return ResponseEntity.ok(tiposucursalActualizado);
    }

    // Eliminar TipoSucursal
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTipoSucursal(@PathVariable Long id) {
        tiposucursalService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
