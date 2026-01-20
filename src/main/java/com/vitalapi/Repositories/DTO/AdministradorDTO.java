package com.vitalapi.Repositories.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AdministradorDTO {
    private Long numeroDocumento;
    private String nombres;
    private String apellidos;
    private String correo;
    private String telefono;
}
