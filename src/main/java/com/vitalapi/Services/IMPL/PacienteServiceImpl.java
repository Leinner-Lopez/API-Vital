package com.vitalapi.Services.IMPL;

import com.vitalapi.Entities.Paciente;
import com.vitalapi.Exceptions.ResourceDuplicateException;
import com.vitalapi.Exceptions.ResourceNotFoundException;
import com.vitalapi.Repositories.PacienteRepository;
import com.vitalapi.Services.PacienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PacienteServiceImpl implements PacienteService {
    private final PacienteRepository pacienteRepository;

    @Override
    public List<Paciente> obtenerPacientes() {
        return pacienteRepository.findAll();
    }

    @Override
    public Paciente obtenerPacientePorId(Long numeroDocumento) {
        return pacienteRepository.findById(numeroDocumento).orElseThrow(() ->{
            throw new ResourceNotFoundException("Paciente con número Documento: " + numeroDocumento + " no encontrado");
        });
    }

    @Override
    public Paciente registrarPaciente(Paciente paciente) {
        if(pacienteRepository.existsByNumeroDocumento(paciente.getNumeroDocumento())) {
            throw new ResourceDuplicateException("Paciente con número Documento: " + paciente.getNumeroDocumento() + " ya existe");
        }
        return pacienteRepository.save(paciente);
    }

    @Override
    public void eliminarPaciente(Long numeroDocumento) {
        pacienteRepository.deleteById(numeroDocumento);
    }

    @Override
    public Paciente actualizarPaciente(Long numeroDocumento, Paciente paciente) {
        Paciente pacienteExistente = pacienteRepository.findById(numeroDocumento).orElse(null);
        if (pacienteExistente != null) {
            pacienteExistente.setNombres(paciente.getNombres());
            pacienteExistente.setApellidos(paciente.getApellidos());
            pacienteExistente.setTipoDocumento(paciente.getTipoDocumento());
            pacienteExistente.setCorreo(paciente.getCorreo());
            pacienteExistente.setTelefono(paciente.getTelefono());
            pacienteExistente.setBarrio(paciente.getBarrio());
            pacienteExistente.setSeguroMedico(paciente.getSeguroMedico());
            if (paciente.getContrasena() != null && !paciente.getContrasena().isEmpty()) {
                pacienteExistente.setContrasena(paciente.getContrasena());
            }
            return pacienteRepository.save(pacienteExistente);
        }
        return null;
    }
}
