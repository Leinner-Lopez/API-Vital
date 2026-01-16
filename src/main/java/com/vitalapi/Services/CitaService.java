package com.vitalapi.Services;

import com.vitalapi.Enums.EstadoCita;
import com.vitalapi.Repositories.DTO.CitaDTO;

import java.util.List;

public interface CitaService {
    //MEDICO,PACIENTE,ADMINISTRADOR
    CitaDTO obtenerCitaPorId(Long idCita);

    //MEDICO, PACIENTE
    CitaDTO agendarCita(CitaDTO cita);
    void actualizarEstadoCita(Long idCita, EstadoCita estadoCita);

    //MEDICO
    List<CitaDTO> obtenerCitasAceptadas(Long numeroDocumentoMedico);
    List<CitaDTO> obtenerCitasPendientes(Long numeroDocumento);
    List<CitaDTO> obtenerCitasCompletadas(Long numeroDocumentoMedico);

    //PACIENTE
    List<CitaDTO> obtenerCitasPaciente(Long numeroDocumentoPaciente);

    //ADMINISTRADOR
    List<CitaDTO> obtenerCitas();
    void eliminarCita(Long idCita);

}
