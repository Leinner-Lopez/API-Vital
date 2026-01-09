package com.vitalapi.Services;

import com.vitalapi.Entities.Medico;
import com.vitalapi.Repositories.DTO.MedicoDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface MedicoService {
    Medico registrarMedico(Medico medico);

    List<MedicoDTO> obtenerMedicos();

    Medico obtenerMedicoPorId(Long numeroDocumento);

    List<MedicoDTO> obtenerMedicosPorEspecialidad(String especialidad);

    void eliminarMedico(Long numeroDocumento);

    Medico actualizarMedico(Long numeroDocumento, Medico medico);
}
