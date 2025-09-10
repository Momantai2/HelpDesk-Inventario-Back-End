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

import com.soporteAtenciones.sistemaAtenciones.dtos.inventario.SucursalRequestDTO;
import com.soporteAtenciones.sistemaAtenciones.dtos.inventario.SucursalResponseDTO;
import com.soporteAtenciones.sistemaAtenciones.service.inventario.SucursalService;



@RestController
@RequestMapping("/api/sucursales")
@CrossOrigin(origins = "http://localhost:4200")
public class SucursalController {


  private final SucursalService sucursalService;

    public SucursalController(SucursalService sucursalService) {
        this.sucursalService = sucursalService;
    }

    // Crear Sucursal
    @PostMapping
    public ResponseEntity<SucursalResponseDTO> crearSucursal(@RequestBody SucursalRequestDTO sucursalRequestDTO) {
        SucursalResponseDTO nuevosucursal = sucursalService.save(sucursalRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevosucursal);
    }

    // Obtener Sucursal por ID
    @GetMapping("/{id}")
    public ResponseEntity<SucursalResponseDTO> obtenerSucursalPorId(@PathVariable Long id) {
        SucursalResponseDTO sucursal = sucursalService.findById(id);
        return ResponseEntity.ok(sucursal);
    }

    // Listar todos los Sucursals
    @GetMapping
    public ResponseEntity<List<SucursalResponseDTO>> listarSucursals() {
        List<SucursalResponseDTO> sucursals = sucursalService.findAll();
        return ResponseEntity.ok(sucursals);
    }

    // Actualizar Sucursals
    @PutMapping("/{id}")
    public ResponseEntity<SucursalResponseDTO> actualizarSucursal(@PathVariable Long id,
        @RequestBody SucursalRequestDTO sucursalRequestDTO) {
        SucursalResponseDTO sucursalActualizado = sucursalService.update(id, sucursalRequestDTO);
        return ResponseEntity.ok(sucursalActualizado);
    }

    // Eliminar Sucursal
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarSucursal(@PathVariable Long id) {
        sucursalService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
