package com.vitalapi.Services.IMPL;

import com.vitalapi.Entities.Administrador;
import com.vitalapi.Entities.Medico;
import com.vitalapi.Exceptions.Class.ResourceDuplicateException;
import com.vitalapi.Exceptions.Class.ResourceNotFoundException;
import com.vitalapi.Repositories.AdministradorRepository;
import com.vitalapi.Repositories.MedicoRepository;
import com.vitalapi.Repositories.PacienteRepository;
import com.vitalapi.Services.AdministradorService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdministradorServiceImpl implements AdministradorService {
    private final AdministradorRepository administradorRepository;
    private final MedicoRepository medicoRepository;
    private final PacienteRepository pacienteRepository;
    private final PasswordEncoder passwordEncoder;

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
        if(administradorRepository.existsByNumeroDocumento(administrador.getNumeroDocumento())
                || medicoRepository.existsByNumeroDocumento(administrador.getNumeroDocumento())
                || pacienteRepository.existsByNumeroDocumento(administrador.getNumeroDocumento())) {
            throw new ResourceDuplicateException("Usuario con Numero de Documento " + administrador.getNumeroDocumento() + " ya existe");
        }
        administrador.setContrasena(passwordEncoder.encode(administrador.getContrasena()));
        return administradorRepository.save(administrador);
    }

    @Override
    public void eliminarAdministrador(Long numeroDocumento) {
        if(!administradorRepository.existsById(numeroDocumento)) {
            throw new ResourceNotFoundException("Administrador con Numero de Documento " + numeroDocumento+ " no encontrado");
        }
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