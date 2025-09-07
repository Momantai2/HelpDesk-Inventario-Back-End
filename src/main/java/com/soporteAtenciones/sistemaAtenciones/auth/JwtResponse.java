package com.soporteAtenciones.sistemaAtenciones.auth;


public class JwtResponse {

    private String token;
    private Long idRol;
    private Long idUsuario;  // agregar

    public JwtResponse(String token, Long rol, Long idUsuario) {
        this.token = token;
        this.idRol = rol;
        this.idUsuario = idUsuario;
    }

    // Getters y setters
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getRol() {
        return idRol;
    }

    public void setRol(Long rol) {
        this.idRol = rol;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
}
