package com.vitalapi.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Disponibilidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "medico_documento", referencedColumnName = "numeroDocumento")
    private Medico medico;

    private LocalDateTime inicioDisponibilidad;
    private LocalDateTime finDisponibilidad;
}
