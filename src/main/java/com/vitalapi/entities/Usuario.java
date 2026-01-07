package com.vitalapi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@MappedSuperclass
@Data
public abstract class Usuario {
    @Id
    protected Long numeroDocumento;
    protected String nombres;
    protected String apellidos;
    protected String tipoDocumento;
    protected String correo;
    protected String telefono;
    protected String barrio;
    protected String contrasena;
}
