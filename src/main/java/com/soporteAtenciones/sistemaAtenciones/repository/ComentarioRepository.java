package com.soporteAtenciones.sistemaAtenciones.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soporteAtenciones.sistemaAtenciones.models.Comentario;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
    List<Comentario> findByTicketIdTicket(Long idTicket);
    List<Comentario> findByTicket_IdTicket(Long idTicket);

}
