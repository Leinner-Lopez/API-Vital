package com.vitalapi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="medico_documento", referencedColumnName = "numeroDocumento")
    private Medico medico;
    private LocalDateTime fechaCita;
    @ManyToOne
    @JoinColumn(name="paciente_documento", referencedColumnName = "numeroDocumento")
    private Paciente paciente;
}
