package com.soporteAtenciones.sistemaAtenciones.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soporteAtenciones.sistemaAtenciones.exception.ResourceNotFoundException;
import com.soporteAtenciones.sistemaAtenciones.models.Ticket;
import com.soporteAtenciones.sistemaAtenciones.repository.TicketRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TicketService {

   
    @Autowired
    private TicketRepository ticketRepository;

   public Ticket crearTicket(Ticket ticket) {
    return ticketRepository.save(ticket);
}

    public Ticket obtenerTicketPorId(Long id) {
        return ticketRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket", "id", id));
    }

    public List<Ticket> listarTickets() {
        return ticketRepository.findAll();
    }

  public Ticket actualizarTicket(Long id, Ticket ticketActualizado) {
    Ticket existente = obtenerTicketPorId(id);

    existente.setTitulo(ticketActualizado.getTitulo());
    existente.setDescripcion(ticketActualizado.getDescripcion());
    existente.setEstado(ticketActualizado.getEstado()); // <-- Este era el error
    existente.setPrioridad(ticketActualizado.getPrioridad());
    existente.setUsuario(ticketActualizado.getUsuario());

    return ticketRepository.save(existente);
}

    public void eliminarTicket(Long id) {
        Ticket existente = obtenerTicketPorId(id);
        ticketRepository.delete(existente);
    }

    public List<Ticket> listarTicketsPorUsuario(String email) {
    return ticketRepository.findByUsuarioEmail(email);
}

  public Ticket findById(Long id) {
        return ticketRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Ticket no encontrado: " + id));
    }
}