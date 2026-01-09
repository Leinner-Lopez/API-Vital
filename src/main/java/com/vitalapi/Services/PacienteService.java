package com.vitalapi.Services;

import com.vitalapi.Entities.Paciente;

import java.util.List;

public interface PacienteService {
    List<Paciente> obtenerPacientes();
    Paciente obtenerPacientePorId(Long numeroDocumento);
    Paciente registrarPaciente(Paciente paciente);
    void eliminarPaciente(Long numeroDocumento);
    Paciente actualizarPaciente(Long numeroDocumento, Paciente paciente);
}
