package com.soporteAtenciones.sistemaAtenciones.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soporteAtenciones.sistemaAtenciones.models.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
 List<Ticket> findByUsuarioEmail(String email);

}
