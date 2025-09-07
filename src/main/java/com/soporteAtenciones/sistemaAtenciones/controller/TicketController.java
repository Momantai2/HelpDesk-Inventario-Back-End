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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.soporteAtenciones.sistemaAtenciones.models.Ticket;
import com.soporteAtenciones.sistemaAtenciones.service.TicketService;


@RestController
@RequestMapping("/api/tickets")
@CrossOrigin(origins = "http://localhost:4200")
public class TicketController {

   private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    // Crear ticket
    @PostMapping
    public ResponseEntity<Ticket> crearTicket(@RequestBody Ticket usuario) {
        Ticket nuevoTicket = ticketService.crearTicket(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoTicket);
    }

    // Obtener usuario por ID
    @GetMapping("/{id}")
    public ResponseEntity<Ticket> obtenerTicketPorId(@PathVariable Long id) {
        Ticket usuario = ticketService.obtenerTicketPorId(id);
        return ResponseEntity.ok(usuario);
    }

    // Listar todos los ticket
   @GetMapping
public ResponseEntity<List<Ticket>> listarTickets(
        @RequestParam(required = false) String usuario) {
    if (usuario != null) {
        return ResponseEntity.ok(ticketService.listarTicketsPorUsuario(usuario));
    } else {
        return ResponseEntity.ok(ticketService.listarTickets());
    }
}


    // Actualizar ticket
    @PutMapping("/{id}")
    public ResponseEntity<Ticket> actualizarTicket(@PathVariable Long id, @RequestBody Ticket usuario) {
        Ticket usuarioActualizado = ticketService.actualizarTicket(id, usuario);
        return ResponseEntity.ok(usuarioActualizado);
    }

    // Eliminar ticket
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTicket(@PathVariable Long id) {
        ticketService.eliminarTicket(id);
        return ResponseEntity.noContent().build();
    }
}