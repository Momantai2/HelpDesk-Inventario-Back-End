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
@Table(name = "Ticket")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTicket;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "idEstado", nullable = false)
    private Estado estado;

    @ManyToOne
    @JoinColumn(name = "idPrioridad", nullable = false)
    private Prioridad prioridad;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;

    private LocalDateTime FechaCreacion;

    @PrePersist
    protected void onCreate() {
        this.FechaCreacion = LocalDateTime.now();
    }
}
