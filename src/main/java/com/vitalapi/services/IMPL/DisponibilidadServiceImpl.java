package com.vitalapi.services.IMPL;

import com.vitalapi.entities.Disponibilidad;
import com.vitalapi.repositories.DisponibilidadRepository;
import com.vitalapi.services.DisponibilidadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class DisponibilidadServiceImpl implements DisponibilidadService {

    private final DisponibilidadRepository disponibilidadRepository;

    @Override
    public Disponibilidad agregarDisponibilidad(Long numeroDocumento) {
        Disponibilidad disponibilidad = new Disponibilidad();
        disponibilidad.setInicioDisponibilidad(LocalDateTime.of(2020, 1, 20, 00, 00));
        disponibilidad.setFinDisponibilidad(LocalDateTime.of(2020, 1, 21, 00, 00));
        return disponibilidadRepository.save(disponibilidad);
    }

    @Override
    public Disponibilidad actualizarDisponibilidad(Long numeroDocumento, Disponibilidad disponibilidad) {
        Disponibilidad disponibilidadExistente = disponibilidadRepository.findById(numeroDocumento).orElse(null);
        if (disponibilidadExistente != null) {
            disponibilidadExistente.setInicioDisponibilidad(disponibilidad.getInicioDisponibilidad());
            disponibilidadExistente.setFinDisponibilidad(disponibilidad.getFinDisponibilidad());
            return disponibilidadRepository.save(disponibilidadExistente);
        }
        return null;
    }

    @Override
    public Disponibilidad obtenerDisponibilidadPorId(Long numeroDocumento) {
        return disponibilidadRepository.findById(numeroDocumento).orElse(null);
    }
}
