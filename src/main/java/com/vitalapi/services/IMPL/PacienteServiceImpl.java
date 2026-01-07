package com.vitalapi.services.IMPL;

import com.vitalapi.entities.Paciente;
import com.vitalapi.repository.PacienteRepository;
import com.vitalapi.services.PacienteService;
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
        return pacienteRepository.findById(numeroDocumento).orElse(null);
    }

    @Override
    public Paciente registrarPaciente(Paciente paciente) {
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
