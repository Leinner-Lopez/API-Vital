package com.vitalapi.Repositories.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CitaDTO {
    private Long id;
    private LocalDateTime fechaCita;
    private String estado;

    private Long documentoMedico;
    private Long documentoPaciente;

    private String nombrePaciente;
    private String nombreMedico;
    private String especialidadMedico;
}
