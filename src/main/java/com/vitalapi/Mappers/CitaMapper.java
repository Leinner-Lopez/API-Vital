package com.vitalapi.Mappers;

import com.vitalapi.Entities.Cita;
import com.vitalapi.Enums.EstadoCita;
import com.vitalapi.Repositories.DTO.CitaDTO;
import com.vitalapi.Services.MedicoService;
import com.vitalapi.Services.PacienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CitaMapper {

    private final MedicoService medicoService;
    private final PacienteService pacienteService;

    public CitaDTO citaToCitaDTO(Cita cita) {
        if (cita == null) return null;
        return new CitaDTO(
                cita.getId(),
                cita.getFechaCita(),
                cita.getEstado().name(),
                cita.getMedico().getNumeroDocumento(),
                cita.getPaciente().getNumeroDocumento(),
                cita.getPaciente().getNombres() + " " + cita.getPaciente().getApellidos(),
                cita.getMedico().getNombres() + " " + cita.getMedico().getApellidos(),
                cita.getMedico().getEspecialidad()
        );
    }

    public Cita CitaDTOtoCita(CitaDTO dto) {
        if (dto == null) return null;
        return new Cita(
                dto.getId(),
                medicoService.obtenerMedicoPorId(dto.getDocumentoMedico()),
                dto.getFechaCita(),
                pacienteService.obtenerPacientePorId(dto.getDocumentoPaciente()),
                EstadoCita.valueOf(dto.getEstado())
        );
    }
}
