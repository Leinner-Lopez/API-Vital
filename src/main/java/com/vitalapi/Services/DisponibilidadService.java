package com.vitalapi.Services;

import com.vitalapi.Entities.Disponibilidad;
import com.vitalapi.Repositories.DTO.DisponibilidadDTO;

import java.time.LocalDate;
import java.util.List;

public interface DisponibilidadService {

    Disponibilidad registrarDisponibilidad (Disponibilidad disponibilidad);
    List<Disponibilidad> obtenerDisponibilidadPorMedico (Long numeroDocumento);
    List<DisponibilidadDTO> consultarDisponibilidadPorDia (Long numeroDocumento, LocalDate fecha);
    void eliminarDisponibilidad (Long id);
}
