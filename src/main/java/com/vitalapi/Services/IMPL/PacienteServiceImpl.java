package com.vitalapi.Services.IMPL;

import com.vitalapi.Entities.Paciente;
import com.vitalapi.Exceptions.Class.ResourceDuplicateException;
import com.vitalapi.Exceptions.Class.ResourceNotFoundException;
import com.vitalapi.Mappers.PacienteMapper;
import com.vitalapi.Repositories.AdministradorRepository;
import com.vitalapi.Repositories.DTO.PacienteDTO;
import com.vitalapi.Repositories.MedicoRepository;
import com.vitalapi.Repositories.PacienteRepository;
import com.vitalapi.Services.PacienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PacienteServiceImpl implements PacienteService {
    private final PacienteRepository pacienteRepository;
    private final AdministradorRepository administradorRepository;
    private final MedicoRepository medicoRepository;
    private final PacienteMapper pacienteMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<PacienteDTO> obtenerPacientes() {
        return pacienteRepository.findAll()
                .stream()
                .map(pacienteMapper::pacienteToPacienteDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Paciente obtenerPacientePorId(Long numeroDocumento) {
        return pacienteRepository.findById(numeroDocumento).orElseThrow(() -> {
            throw new ResourceNotFoundException("Paciente con número Documento: " + numeroDocumento + " no encontrado");
        });
    }

    @Override
    public Paciente registrarPaciente(Paciente paciente) {
        if (pacienteRepository.existsByNumeroDocumento(paciente.getNumeroDocumento())
                || administradorRepository.existsByNumeroDocumento(paciente.getNumeroDocumento())
                || medicoRepository.existsByNumeroDocumento(paciente.getNumeroDocumento())) {
            throw new ResourceDuplicateException("Usuario con número Documento: " + paciente.getNumeroDocumento() + " ya existe");
        }
        paciente.setContrasena(passwordEncoder.encode(paciente.getContrasena()));
        return pacienteRepository.save(paciente);
    }

    @Override
    public void eliminarPaciente(Long numeroDocumento) {
        if (!pacienteRepository.existsByNumeroDocumento(numeroDocumento)) {
            throw new ResourceNotFoundException("Paciente con número Documento: " + numeroDocumento + " no encontrado");
        }
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
