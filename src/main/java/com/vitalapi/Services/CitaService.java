package com.vitalapi.Services;

import com.vitalapi.Enums.EstadoCita;
import com.vitalapi.Repositories.DTO.CitaRequestDTO;
import com.vitalapi.Repositories.DTO.CitaResponseDTO;

import java.util.List;

public interface CitaService {
    //MEDICO,PACIENTE,ADMINISTRADOR
    CitaResponseDTO obtenerCitaPorId(Long idCita);

    //MEDICO, PACIENTE
    CitaResponseDTO agendarCita(CitaRequestDTO cita);
    void actualizarEstadoCita(Long idCita, EstadoCita estadoCita);

    //MEDICO
    List<CitaResponseDTO> obtenerCitasMedicoNumeroDocumento(Long numeroDocumento);
    List<CitaResponseDTO> obtenerCitasMedicoPorEstado(Long numeroDocumento, EstadoCita estado);

    //PACIENTE
    List<CitaResponseDTO> obtenerCitasPaciente(Long numeroDocumento);
    List<CitaResponseDTO> obtenerCitasPacientePorEstado(Long numeroDocumento, EstadoCita estado);

    //ADMINISTRADOR
    List<CitaResponseDTO> obtenerCitasPorEstado(EstadoCita estado);
    List<CitaResponseDTO> obtenerCitas();
    void eliminarCita(Long idCita);

}
