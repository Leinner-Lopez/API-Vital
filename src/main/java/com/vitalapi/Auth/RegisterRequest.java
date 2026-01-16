package com.vitalapi.Auth;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    Long numeroDocumento;
    String nombres;
    String apellidos;
    String tipoDocumento;
    String correo;
    String telefono;
    String barrio;
    String contrasena;
    String seguroMedico;
}
