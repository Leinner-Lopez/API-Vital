package com.vitalapi.Mappers;

import com.vitalapi.Entities.Paciente;
import com.vitalapi.Repositories.DTO.PacienteDTO;
import org.springframework.stereotype.Component;

@Component
public class PacienteMapper {
    public PacienteDTO pacienteToPacienteDTO(Paciente paciente) {
        return new PacienteDTO(
                paciente.getNumeroDocumento(),
                paciente.getNombres(),
                paciente.getApellidos(),
                paciente.getCorreo(),
                paciente.getSeguroMedico()
        );
    }
}
