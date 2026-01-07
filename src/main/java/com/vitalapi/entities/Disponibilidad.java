package com.vitalapi.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Disponibilidad {
    @Id
    private Long documentoMedico;
    @Column(columnDefinition = "DATETIME DEFAULT '1999-01-01 00:00:00'")
    private LocalDateTime inicioDisponibilidad;
    @Column(columnDefinition = "DATETIME DEFAULT '1999-01-02 00:00:00'")
    private LocalDateTime finDisponibilidad;
}
