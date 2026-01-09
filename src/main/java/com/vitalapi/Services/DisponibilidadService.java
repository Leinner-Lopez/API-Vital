package com.vitalapi.Services;

import com.vitalapi.Entities.Disponibilidad;

public interface DisponibilidadService {
    Disponibilidad agregarDisponibilidad (Long numeroDocumento);
    Disponibilidad actualizarDisponibilidad (Long numeroDocumento, Disponibilidad disponibilidad);
    Disponibilidad obtenerDisponibilidadPorId (Long numeroDocumento);
}
