package com.vitalapi.services;

import com.vitalapi.entities.Administrador;

import java.util.List;

public interface AdministradorService {
    List<Administrador> obtenerAdministradores();
    Administrador obtenerAdministradorPorId(Long numeroDocumento);
    Administrador registrarAdministrador(Administrador administrador);
    void eliminarAdministrador(Long numeroDocumento);
    Administrador actualizarAdministrador(Long numeroDocumento, Administrador administrador);
}
