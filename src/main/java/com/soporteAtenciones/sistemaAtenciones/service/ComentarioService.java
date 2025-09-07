package com.soporteAtenciones.sistemaAtenciones.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soporteAtenciones.sistemaAtenciones.exception.ResourceNotFoundException;
import com.soporteAtenciones.sistemaAtenciones.models.Comentario;
import com.soporteAtenciones.sistemaAtenciones.repository.ComentarioRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ComentarioService {

   
    @Autowired
    private ComentarioRepository comentarioRepository;

   public Comentario crearComentario(Comentario Comentario) {
    return comentarioRepository.save(Comentario);
}

    public Comentario obtenerComentarioPorId(Long id) {
        return comentarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comentario", "id", id));
    }

    public List<Comentario> listarComentarios() {
        return comentarioRepository.findAll();
    }

  public Comentario actualizarComentario(Long id, Comentario comentarioactualizado) {
    Comentario existente = obtenerComentarioPorId(id);
    existente.setUsuario(comentarioactualizado.getUsuario());
    existente.setTexto(comentarioactualizado.getTexto());
    existente.setTicket(comentarioactualizado.getTicket());
    return comentarioRepository.save(existente);
}

    public void eliminarComentario(Long id) {
        Comentario existente = obtenerComentarioPorId(id);
        comentarioRepository.delete(existente);
    }

      public List<Comentario> listarComentariosPorTicket(Long ticketId) {
        return comentarioRepository.findByTicketIdTicket(ticketId);
    }
}

 