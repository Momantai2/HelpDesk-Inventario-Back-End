
package com.soporteAtenciones.sistemaAtenciones.service;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soporteAtenciones.sistemaAtenciones.dtos.tickets.UsuarioRequestDTO;
import com.soporteAtenciones.sistemaAtenciones.dtos.tickets.UsuarioResponseDTO;
import com.soporteAtenciones.sistemaAtenciones.mappers.UsuarioMapper;
import com.soporteAtenciones.sistemaAtenciones.models.Usuario;
import com.soporteAtenciones.sistemaAtenciones.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository, UsuarioMapper usuarioMapper) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
    }

    public List<UsuarioResponseDTO> findAll() {
        return usuarioRepository.findAll().stream()
                .map(usuarioMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    public UsuarioResponseDTO findById(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con id: " + id));
        return usuarioMapper.toResponseDto(usuario);
    }
    
  public UsuarioResponseDTO findByEmail(String email) {
    Usuario usuario = usuarioRepository.findByEmail(email);
    if (usuario == null) {
        throw new RuntimeException("Usuario no encontrado con email: " + email);
    }
    return usuarioMapper.toResponseDto(usuario);
}

    public UsuarioResponseDTO save(UsuarioRequestDTO usuarioRequestDTO) {
        // Validación o lógica de negocio antes de guardar
        Usuario usuario = usuarioMapper.toEntity(usuarioRequestDTO);
        Usuario savedUsuario = usuarioRepository.save(usuario);
        return usuarioMapper.toResponseDto(savedUsuario);
    }

    public UsuarioResponseDTO update(Long id, UsuarioRequestDTO usuarioRequestDTO) {
        Usuario existingUsuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con id: " + id));
        
        usuarioMapper.updateEntityFromDto(usuarioRequestDTO, existingUsuario);
        Usuario updatedUsuario = usuarioRepository.save(existingUsuario);
        return usuarioMapper.toResponseDto(updatedUsuario);
    }

    public void deleteById(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new RuntimeException("Usuario no encontrado con id: " + id);
        }
        usuarioRepository.deleteById(id);
    }
}