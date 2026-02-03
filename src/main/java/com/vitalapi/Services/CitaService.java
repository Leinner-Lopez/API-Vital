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
    List<CitaDTO> obtenerCitasMedicoNumeroDocumento(Long numeroDocumento);
    List<CitaDTO> obtenerCitasMedicoPorEstado(Long numeroDocumento, EstadoCita estado);

    //PACIENTE
    List<CitaDTO> obtenerCitasPaciente(Long numeroDocumento);
    List<CitaDTO> obtenerCitasPacientePorEstado(Long numeroDocumento, EstadoCita estado);

    //ADMINISTRADOR
    List<CitaDTO> obtenerCitasPorEstado(EstadoCita estado);
    List<CitaDTO> obtenerCitas();
    void eliminarCita(Long idCita);

}
