package com.vitalapi.Mappers;

import com.vitalapi.Entities.Administrador;
import com.vitalapi.Repositories.DTO.AdministradorDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AdministradorMapper {

    public AdministradorDTO administradorToAdministradorDTO(Administrador administrador) {
        return new AdministradorDTO(
                administrador.getNumeroDocumento(),
                administrador.getNombres(),
                administrador.getApellidos(),
                administrador.getCorreo(),
                administrador.getTelefono()
        );
    }
}
