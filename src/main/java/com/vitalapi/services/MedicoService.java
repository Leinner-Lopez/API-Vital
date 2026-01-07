package com.vitalapi.services;

import com.vitalapi.entities.Medico;
import com.vitalapi.repository.DTO.MedicoDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface MedicoService {
    List<Medico> obtenerMedicos();
    List<MedicoDTO> obtenerMedicosconDisponibilidad();
    List<LocalDateTime> obtenerFechasDisponiblesMedico(Long numeroDocumento);
    Medico obtenerMedicoPorId(Long numeroDocumento);
    Medico registrarMedico(Medico medico);
    void eliminarMedico(Long numeroDocumento);
    Medico actualizarMedico(Long numeroDocumento, Medico medico);
}
