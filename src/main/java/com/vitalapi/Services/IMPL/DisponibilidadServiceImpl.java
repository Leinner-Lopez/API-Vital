package com.vitalapi.Services.IMPL;

import com.vitalapi.Entities.Cita;
import com.vitalapi.Entities.Disponibilidad;
import com.vitalapi.Repositories.CitaRepository;
import com.vitalapi.Repositories.DTO.DisponibilidadDTO;
import com.vitalapi.Repositories.DisponibilidadRepository;
import com.vitalapi.Services.DisponibilidadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DisponibilidadServiceImpl implements DisponibilidadService {

    private final DisponibilidadRepository disponibilidadRepository;
    private final CitaRepository citaRepository;


    @Override
    public Disponibilidad registrarDisponibilidad(Disponibilidad disponibilidad) {
        return disponibilidadRepository.save(disponibilidad);
    }

    @Override
    public List<Disponibilidad> obtenerDisponibilidadPorMedico(Long numeroDocumento) {
        return disponibilidadRepository.findByMedicoNumeroDocumento(numeroDocumento);
    }

    @Override
    public List<DisponibilidadDTO> consultarDisponibilidadPorDia(Long numeroDocumento, LocalDate fecha) {
        LocalDateTime inicioDia = fecha.atStartOfDay();
        LocalDateTime finDia = fecha.atTime(LocalTime.MAX);

        List<Disponibilidad> franjas = disponibilidadRepository.buscarPorMedicoYFecha(numeroDocumento,inicioDia,finDia);
        List<Cita> citasExistentes = citaRepository.findByMedicoNumeroDocumentoAndFechaCitaBetween(numeroDocumento,inicioDia,finDia);

        List<DisponibilidadDTO> HorasDisponibles = new ArrayList<>();

        for(Disponibilidad franja : franjas){

            LocalDateTime tiempoActual = franja.getInicioDisponibilidad();

            while(tiempoActual.plusMinutes(30).isBefore(franja.getFinDisponibilidad()) || tiempoActual.plusMinutes(30).isEqual(franja.getFinDisponibilidad())){

                LocalDateTime inicioBloque = tiempoActual;

                boolean estaOcupado = citasExistentes.stream()
                        .anyMatch(cita -> cita.getFechaCita().equals(inicioBloque));

                if(!estaOcupado){
                    HorasDisponibles.add(new DisponibilidadDTO(inicioBloque, inicioBloque.plusMinutes(30)));
                }

                tiempoActual = tiempoActual.plusMinutes(30);
            }
        }

        return HorasDisponibles;
    }

    @Override
    public void eliminarDisponibilidad(Long id) {
        disponibilidadRepository.deleteById(id);
    }
}
