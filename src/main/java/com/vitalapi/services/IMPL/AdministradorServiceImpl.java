package com.vitalapi.services.IMPL;

import com.vitalapi.entities.Administrador;
import com.vitalapi.exception.ResourceNotFoundException;
import com.vitalapi.repositories.AdministradorRepository;
import com.vitalapi.services.AdministradorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdministradorServiceImpl implements AdministradorService {
    private final AdministradorRepository administradorRepository;

    @Override
    public List<Administrador> obtenerAdministradores() {
        return administradorRepository.findAll();
    }

    @Override
    public Administrador obtenerAdministradorPorId(Long numeroDocumento) {
        return administradorRepository.findById(numeroDocumento).orElseThrow(() ->
        {throw new ResourceNotFoundException("Administrador con Numero de Documento " + numeroDocumento+ " no encontrado");});
    }

    @Override
    public Administrador registrarAdministrador(Administrador administrador) {
        return administradorRepository.save(administrador);
    }

    @Override
    public void eliminarAdministrador(Long numeroDocumento) {
        administradorRepository.deleteById(numeroDocumento);
    }

    @Override
    public Administrador actualizarAdministrador(Long numeroDocumento, Administrador administrador) {
        Administrador administradorDB = administradorRepository.findById(numeroDocumento).orElse(null);
        if (administradorDB != null) {
            administradorDB.setNombres(administrador.getNombres());
            administradorDB.setApellidos(administrador.getApellidos());
            administradorDB.setTipoDocumento(administrador.getTipoDocumento());
            administradorDB.setCorreo(administrador.getCorreo());
            administradorDB.setTelefono(administrador.getTelefono());
            administradorDB.setBarrio(administrador.getBarrio());
            if(administrador.getContrasena()!=null && !administrador.getContrasena().isEmpty()){
                administradorDB.setContrasena(administrador.getContrasena());
            }
            return administradorRepository.save(administradorDB);
        }
        return null;
    }
}