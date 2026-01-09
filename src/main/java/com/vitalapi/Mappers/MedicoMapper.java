package com.vitalapi.Mappers;

import com.vitalapi.Entities.Medico;
import com.vitalapi.Repositories.DTO.MedicoDTO;
import org.springframework.stereotype.Component;

@Component
public class MedicoMapper {

    public MedicoDTO medicoToMedicoDTO(Medico medico){
        if(medico == null){return null;}
        return new MedicoDTO(
                medico.getNumeroDocumento(),
                medico.getNombres(),
                medico.getApellidos(),
                medico.getCorreo(),
                medico.getEspecialidad()
        );
    }
}
