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
import org.springframework.web.bind.annotation.RestController;

import com.soporteAtenciones.sistemaAtenciones.dtos.tickets.TicketRequestDTO;
import com.soporteAtenciones.sistemaAtenciones.dtos.tickets.TicketResponseDTO;
import com.soporteAtenciones.sistemaAtenciones.service.TicketService;


@RestController
@RequestMapping("/api/tickets")
@CrossOrigin(origins = "http://localhost:4200")
public class TicketController {


    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    // Crear Ticket
    @PostMapping
    public ResponseEntity<TicketResponseDTO> crearTiquet(@RequestBody TicketRequestDTO ticketRequestDTO) {
        TicketResponseDTO nuevoticket = ticketService.save(ticketRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoticket);
    }

    // Obtener ticket por ID
    @GetMapping("/{id}")
    public ResponseEntity<TicketResponseDTO> obtenerTicketPorId(@PathVariable Long id) {
        TicketResponseDTO ticket = ticketService.findById(id);
        return ResponseEntity.ok(ticket);
    }

    // Listar todos los Tickets
    @GetMapping
    public ResponseEntity<List<TicketResponseDTO>> listarTickets() {
        List<TicketResponseDTO> tickets = ticketService.findAll();
        return ResponseEntity.ok(tickets);
    }

    // Actualizar ticket
    @PutMapping("/{id}")
    public ResponseEntity<TicketResponseDTO> actualizarTicket(@PathVariable Long id,
        @RequestBody TicketRequestDTO ticketRequestDTO) {
        TicketResponseDTO ticketActualizado = ticketService.update(id, ticketRequestDTO);
        return ResponseEntity.ok(ticketActualizado);
    }

    // Eliminar ticket
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTicket(@PathVariable Long id) {
        ticketService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
