package com.soporteAtenciones.sistemaAtenciones.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.soporteAtenciones.sistemaAtenciones.dtos.tickets.ComentarioRequestDTO;
import com.soporteAtenciones.sistemaAtenciones.dtos.tickets.ComentarioResponseDTO;
import com.soporteAtenciones.sistemaAtenciones.exception.ResourceNotFoundException;
import com.soporteAtenciones.sistemaAtenciones.mappers.ComentarioMapper;
import com.soporteAtenciones.sistemaAtenciones.models.Comentario;
import com.soporteAtenciones.sistemaAtenciones.models.Ticket;
import com.soporteAtenciones.sistemaAtenciones.models.Usuario;
import com.soporteAtenciones.sistemaAtenciones.repository.ComentarioRepository;
import com.soporteAtenciones.sistemaAtenciones.repository.TicketRepository;
import com.soporteAtenciones.sistemaAtenciones.repository.UsuarioRepository;

@Service
public class ComentarioService {

    private final ComentarioRepository comentarioRepository;
    private final TicketRepository ticketRepository;
    private final UsuarioRepository usuarioRepository;
    private final ComentarioMapper comentarioMapper;

    public ComentarioService(ComentarioRepository comentarioRepository,
         TicketRepository ticketRepository,
         UsuarioRepository usuarioRepository,
        ComentarioMapper comentarioMapper) {
        this.comentarioRepository = comentarioRepository;
        this.ticketRepository = ticketRepository;
        this.usuarioRepository = usuarioRepository;
        this.comentarioMapper = comentarioMapper;
    }

    @Transactional
    public ComentarioResponseDTO crearComentario(ComentarioRequestDTO request) {
        // Validar que el ticket y el usuario existen
        Ticket ticket = ticketRepository.findById(request.getIdTicket())
                .orElseThrow(() -> new ResourceNotFoundException("Ticket", "id", request.getIdTicket()));

        Usuario usuario = usuarioRepository.findById(request.getIdUsuario())
                .orElseThrow(() -> new ResourceNotFoundException("Usuario", "id", request.getIdUsuario()));

        Comentario comentario = comentarioMapper.toEntity(request);
        comentario.setTicket(ticket);
        comentario.setUsuario(usuario);

        return comentarioMapper.toResponseDto(comentarioRepository.save(comentario));
    }

    public ComentarioResponseDTO obtenerComentarioPorId(Long id) {
        Comentario comentario = comentarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comentario", "id", id));

        return comentarioMapper.toResponseDto(comentario);
    }

    public List<ComentarioResponseDTO> listarComentariosPorTicket(Long ticketId) {
        if (!ticketRepository.existsById(ticketId)) {
            throw new ResourceNotFoundException("Ticket", "id", ticketId);
        }

        return comentarioRepository.findByTicket_IdTicket(ticketId).stream()
                .map(comentarioMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public ComentarioResponseDTO actualizarComentario(Long id, ComentarioRequestDTO request) {
        Comentario existente = comentarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comentario", "id", id));
                
        // Validar que el ticket y el usuario existen
        Ticket ticket = ticketRepository.findById(request.getIdTicket())
                .orElseThrow(() -> new ResourceNotFoundException("Ticket", "id", request.getIdTicket()));

        Usuario usuario = usuarioRepository.findById(request.getIdUsuario())
                .orElseThrow(() -> new ResourceNotFoundException("Usuario", "id", request.getIdUsuario()));

        existente.setTexto(request.getTexto());
        existente.setTicket(ticket);
        existente.setUsuario(usuario);
        
        return comentarioMapper.toResponseDto(comentarioRepository.save(existente));
    }

    @Transactional
    public void eliminarComentario(Long id) {
        if (!comentarioRepository.existsById(id)) {
            throw new ResourceNotFoundException("Comentario", "id", id);
        }
        comentarioRepository.deleteById(id);
    }

    public List<ComentarioResponseDTO> listarTodosLosComentarios() {
    return comentarioRepository.findAll().stream()
            .map(comentarioMapper::toResponseDto)
            .collect(Collectors.toList());
}

}