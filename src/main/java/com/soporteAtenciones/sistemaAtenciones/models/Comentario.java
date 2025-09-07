package com.soporteAtenciones.sistemaAtenciones.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="Comentario")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idComentario;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String texto;

    @ManyToOne
    @JoinColumn(name = "idTicket", nullable = false)
    private Ticket ticket;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;

    private LocalDateTime FechaCreacion;

    @PrePersist
    protected void onCreate() {
        this.FechaCreacion = LocalDateTime.now();
    }

}
