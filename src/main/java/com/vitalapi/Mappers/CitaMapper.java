package com.vitalapi.Mappers;

import com.vitalapi.Entities.Cita;
import com.vitalapi.Enums.EstadoCita;
import com.vitalapi.Repositories.DTO.CitaRequestDTO;
import com.vitalapi.Repositories.DTO.CitaResponseDTO;
import com.vitalapi.Services.MedicoService;
import com.vitalapi.Services.PacienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CitaMapper {

    private final MedicoService medicoService;
    private final PacienteService pacienteService;

    public CitaResponseDTO citaToCitaDTO(Cita cita) {
        if (cita == null) return null;
        return new CitaResponseDTO(
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

    public Cita CitaRDTOtoCita(CitaRequestDTO dto){
        if(dto == null) return null;
        return new Cita(
                null,
                medicoService.obtenerMedicoPorId(dto.getDocumentoMedico()),
                dto.getFechaCita(),
                pacienteService.obtenerPacientePorId(dto.getDocumentoPaciente()),
                null
        );
    }

    public Cita CitaDTOtoCita(CitaResponseDTO dto) {
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
