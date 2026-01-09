package com.vitalapi.Mappers;

import com.vitalapi.Entities.Disponibilidad;
import com.vitalapi.Repositories.DTO.DisponibilidadDTO;
import org.springframework.stereotype.Component;

@Component
public class DisponibilidadMapper {
    public DisponibilidadDTO disponibilidadToDisponibilidadDTO(Disponibilidad disponibilidad) {
        return new DisponibilidadDTO(
                disponibilidad.getInicioDisponibilidad(),
                disponibilidad.getFinDisponibilidad()
        );
    }
}
