package com.vitalapi.Services;

import com.vitalapi.Entities.Administrador;
import com.vitalapi.Repositories.DTO.AdministradorDTO;

import java.util.List;

public interface AdministradorService {
    List<AdministradorDTO> obtenerAdministradores();
    Administrador obtenerAdministradorPorId(Long numeroDocumento);
    Administrador registrarAdministrador(Administrador administrador);
    void eliminarAdministrador(Long numeroDocumento);
    Administrador actualizarAdministrador(Long numeroDocumento, Administrador administrador);
}
