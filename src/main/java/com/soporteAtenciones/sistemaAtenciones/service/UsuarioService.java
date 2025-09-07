package com.soporteAtenciones.sistemaAtenciones.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.soporteAtenciones.sistemaAtenciones.exception.DuplicateResourceException;
import com.soporteAtenciones.sistemaAtenciones.exception.ResourceNotFoundException;
import com.soporteAtenciones.sistemaAtenciones.models.Usuario;
import com.soporteAtenciones.sistemaAtenciones.repository.UsuarioRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class UsuarioService {

 private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional
      public Usuario crearUsuario(Usuario usuario) {
        if (usuarioRepository.existsByEmail(usuario.getEmail())) {
            throw new DuplicateResourceException("Usuario", "email", usuario.getEmail());
        }
        // fechaCreacion se setea con @PrePersist
        return usuarioRepository.save(usuario);
    }

    public Usuario obtenerUsuarioPorId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario", "id", id));
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    @Transactional
    public Usuario actualizarUsuario(Long id, Usuario ticketActualizado) {
        Usuario existente = obtenerUsuarioPorId(id);

        existente.setNombre(ticketActualizado.getNombre());
        existente.setEmail(ticketActualizado.getEmail());
        existente.setPassword(ticketActualizado.getPassword());
        existente.setRol(ticketActualizado.getRol());

        return usuarioRepository.save(existente);
    }

    @Transactional
    public void eliminarUsuario(Long id) {
        Usuario existente = obtenerUsuarioPorId(id);
        usuarioRepository.delete(existente);
    }
    public Usuario findById(Long id) {
        return usuarioRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado: " + id));
    }
}