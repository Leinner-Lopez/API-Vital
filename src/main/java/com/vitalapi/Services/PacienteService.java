package com.vitalapi.Services;

import com.vitalapi.Entities.Paciente;
import com.vitalapi.Repositories.DTO.PacienteDTO;

import java.util.List;

public interface PacienteService {
    List<PacienteDTO> obtenerPacientes();
    Paciente obtenerPacientePorId(Long numeroDocumento);
    Paciente registrarPaciente(Paciente paciente);
    void eliminarPaciente(Long numeroDocumento);
    Paciente actualizarPaciente(Long numeroDocumento, Paciente paciente);
}
