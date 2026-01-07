package com.vitalapi.repository.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CitaDTO {
    private Long Id;
    private String nombrePaciente;
    private String nombreMedico;
    private String especialidadMedico;
    private LocalDateTime fechaCita;
}
