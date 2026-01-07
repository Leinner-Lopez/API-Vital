package com.vitalapi.services;

import com.vitalapi.entities.Cita;
import com.vitalapi.repository.DTO.CitaDTO;

import java.util.List;

public interface CitaService {
    Cita agendarCita(Cita cita);
    Cita obtenerCitaporId(Long id);
    Cita ReprogramarCita(Long id, Cita cita);
    List<CitaDTO> CitasDocumentoPaciente(Long numeroDocumento);
    List<CitaDTO> CitasDocumentoMedico(Long numeroDocumento);
    List<CitaDTO> ListarCitasMedicas();
    void eliminarCita(Long id);
}
