package com.vitalapi.services;

import com.vitalapi.entities.Disponibilidad;

public interface DisponibilidadService {
    Disponibilidad agregarDisponibilidad (Long numeroDocumento);
    Disponibilidad actualizarDisponibilidad (Long numeroDocumento, Disponibilidad disponibilidad);
    Disponibilidad obtenerDisponibilidadPorId (Long numeroDocumento);
}
