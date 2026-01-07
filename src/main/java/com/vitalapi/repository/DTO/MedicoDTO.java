package com.vitalapi.repository.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicoDTO {
    private Long numeroDocumento;
    private String nombres;
    private String apellidos;
    private String especialidad;
    private LocalDateTime disponibilidadFinal;
}
