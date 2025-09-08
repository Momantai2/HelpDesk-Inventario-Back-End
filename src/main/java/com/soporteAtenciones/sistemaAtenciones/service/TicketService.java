
package com.soporteAtenciones.sistemaAtenciones.service;



import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soporteAtenciones.sistemaAtenciones.dtos.tickets.TicketRequestDTO;
import com.soporteAtenciones.sistemaAtenciones.dtos.tickets.TicketResponseDTO;
import com.soporteAtenciones.sistemaAtenciones.mappers.TicketMapper;
import com.soporteAtenciones.sistemaAtenciones.models.Ticket;
import com.soporteAtenciones.sistemaAtenciones.repository.TicketRepository;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;
    private final TicketMapper ticketMapper;

    @Autowired
    public TicketService(TicketRepository ticketRepository, TicketMapper ticketMapper) {
        this.ticketRepository = ticketRepository;
        this.ticketMapper = ticketMapper;
    }

    public List<TicketResponseDTO> findAll() {
         List<Ticket> tickets = ticketRepository.findAll(); // asegúrate que esto traiga usuario
    return tickets.stream()
                  .map(ticketMapper::toResponseDto)
                  .collect(Collectors.toList());
}
    public TicketResponseDTO findById(Long id) {
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket no encontrado con id: " + id));
        return ticketMapper.toResponseDto(ticket);
    }

    public TicketResponseDTO save(TicketRequestDTO ticketRequestDTO) {
        Ticket ticket = ticketMapper.toEntity(ticketRequestDTO);
        Ticket savedTicket = ticketRepository.save(ticket);
        return ticketMapper.toResponseDto(savedTicket);
    }

    public TicketResponseDTO update(Long id, TicketRequestDTO ticketRequestDTO) {
        Ticket existingTicket = ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket no encontrado con id: " + id));

        ticketMapper.updateEntityFromDto(ticketRequestDTO, existingTicket);
        Ticket updatedTicket = ticketRepository.save(existingTicket);
        return ticketMapper.toResponseDto(updatedTicket);
    }

    public void deleteById(Long id) {
        if (!ticketRepository.existsById(id)) {
            throw new RuntimeException("Ticket no encontrado con id: " + id);
        }
        ticketRepository.deleteById(id);
    }
}