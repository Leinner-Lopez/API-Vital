package com.vitalapi.Services;

import com.vitalapi.Entities.Disponibilidad;
import com.vitalapi.Repositories.DTO.DisponibilidadDTO;
import com.vitalapi.Repositories.DTO.DisponibilidadDtoHoras;

import java.time.LocalDate;
import java.util.List;

public interface DisponibilidadService {

    DisponibilidadDTO registrarDisponibilidad (DisponibilidadDTO disponibilidad);
    List<DisponibilidadDTO> obtenerDisponibilidadPorMedico (Long numeroDocumento);
    List<DisponibilidadDtoHoras> consultarDisponibilidadPorDia (Long numeroDocumento, LocalDate fecha);
    void eliminarDisponibilidad (Long id);
}
