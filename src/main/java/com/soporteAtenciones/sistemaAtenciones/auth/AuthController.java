package com.soporteAtenciones.sistemaAtenciones.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soporteAtenciones.sistemaAtenciones.config.JwtUtil;
import com.soporteAtenciones.sistemaAtenciones.models.Usuario;
import com.soporteAtenciones.sistemaAtenciones.repository.UsuarioRepository;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

  @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JwtUtil jwtUtil;

   @PostMapping("/login")
public ResponseEntity<?> login(@RequestBody Usuario request) {
    String email = request.getEmail().trim();

    String password = request.getPassword().trim();

    Usuario usuario = usuarioRepository.findByEmail(email);

    if (usuario == null) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuario no encontrado");
    }

    if (!usuario.getPassword().equals(password)) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Contraseña incorrecta");
    }

    Long idRol = null;
    if (usuario.getRol() != null) {
        idRol = usuario.getRol().getIdRol();
    }

    String token = jwtUtil.generateToken(email, usuario.getRol() != null ? usuario.getRol().getNombre() : "ROLE_DEFAULT");

    JwtResponse response = new JwtResponse(token, idRol, usuario.getIdUsuario());  // Pasar idUsuario aquí

    return ResponseEntity.ok(response);
}


}
