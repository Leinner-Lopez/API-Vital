package com.vitalapi.Services;

import com.vitalapi.Entities.Administrador;

import java.util.List;

public interface AdministradorService {
    List<Administrador> obtenerAdministradores();
    Administrador obtenerAdministradorPorId(Long numeroDocumento);
    Administrador registrarAdministrador(Administrador administrador);
    void eliminarAdministrador(Long numeroDocumento);
    Administrador actualizarAdministrador(Long numeroDocumento, Administrador administrador);
}
