package com.vitalapi.Mappers;

import com.vitalapi.Entities.Disponibilidad;
import com.vitalapi.Repositories.DTO.DisponibilidadDTO;
import com.vitalapi.Services.MedicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DisponibilidadMapper {

    private final MedicoService medicoService;

    public Disponibilidad disponibilidadDtoToDisponibilidad(DisponibilidadDTO disponibilidadDTO){
        return new Disponibilidad(
                disponibilidadDTO.getId(),
                medicoService.obtenerMedicoPorId(disponibilidadDTO.getId()),
                disponibilidadDTO.getInicioDisponibilidad(),
                disponibilidadDTO.getFinDisponibilidad()
        );
    }

    public DisponibilidadDTO disponibilidadToDisponibilidadDTO(Disponibilidad disponibilidad){

        return new DisponibilidadDTO(
                disponibilidad.getId(),
                disponibilidad.getMedico().getNumeroDocumento(),
                disponibilidad.getInicioDisponibilidad(),
                disponibilidad.getFinDisponibilidad()
        );
    }
}
