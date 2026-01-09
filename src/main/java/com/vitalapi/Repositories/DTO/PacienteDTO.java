package com.vitalapi.Repositories.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PacienteDTO {
    private Long numeroDocumento;
    private String nombres;
    private String apellidos;
    private String correo;
    private String seguroMedico;
}
