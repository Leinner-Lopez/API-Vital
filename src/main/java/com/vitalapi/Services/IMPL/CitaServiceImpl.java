package com.vitalapi.Services.IMPL;

import com.vitalapi.Entities.Cita;
import com.vitalapi.Enums.EstadoCita;
import com.vitalapi.Exceptions.Class.IlegalActionException;
import com.vitalapi.Exceptions.Class.ResourceNotFoundException;
import com.vitalapi.Mappers.CitaMapper;
import com.vitalapi.Repositories.CitaRepository;
import com.vitalapi.Repositories.DTO.CitaDTO;
import com.vitalapi.Services.CitaService;
import com.vitalapi.Services.MedicoService;
import com.vitalapi.Services.PacienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CitaServiceImpl implements CitaService {

    private final CitaRepository citaRepository;
    private final CitaMapper citaMapper;


    @Override
    public CitaDTO obtenerCitaPorId(Long idCita) {
        return citaMapper.citaToCitaDTO(citaRepository.findById(idCita)
                .orElseThrow(() -> {
                    throw new ResourceNotFoundException("Cita con Id " + idCita + " no encontrado");
                }));
    }

    @Override
    public CitaDTO agendarCita(CitaDTO dto) {
        if (dto.getFechaCita().isBefore(LocalDateTime.now())) {
            throw new IlegalActionException("No se puede agendar una Cita Medica en el Pasado");
        }
        Cita cita = citaMapper.CitaDTOtoCita(dto);
        cita.setEstado(EstadoCita.PENDIENTE);
        return citaMapper.citaToCitaDTO(citaRepository.save(cita));
    }

    @Override
    public List<CitaDTO> obtenerCitasAceptadas(Long numeroDocumentoMedico) {
        return citaRepository.findByMedicoNumeroDocumentoAndEstado(numeroDocumentoMedico, EstadoCita.ACEPTADA)
                .stream()
                .map(citaMapper::citaToCitaDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<CitaDTO> obtenerCitasPendientes(Long numeroDocumento) {
        return citaRepository.findByMedicoNumeroDocumentoAndEstado(numeroDocumento, EstadoCita.PENDIENTE)
                .stream()
                .map(citaMapper::citaToCitaDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void actualizarEstadoCita(Long idCita, EstadoCita estadoCita) {
        CitaDTO dto = obtenerCitaPorId(idCita);
        Cita cita = citaMapper.CitaDTOtoCita(dto);
        cita.setEstado(estadoCita);
        citaRepository.save(cita);
    }

    @Override
    public List<CitaDTO> obtenerCitasCompletadas(Long numeroDocumentoMedico) {
        return citaRepository.findByMedicoNumeroDocumentoAndEstado(numeroDocumentoMedico, EstadoCita.COMPLETADA)
                .stream()
                .map(citaMapper::citaToCitaDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<CitaDTO> obtenerCitasPaciente(Long numeroDocumentoPaciente) {
        return citaRepository.findByPacienteNumeroDocumento(numeroDocumentoPaciente)
                .stream()
                .map(citaMapper::citaToCitaDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<CitaDTO> obtenerCitas() {
        return citaRepository.findAll().stream().map((citaMapper::citaToCitaDTO)).collect(Collectors.toList());
    }

    @Override
    public void eliminarCita(Long idCita) {

        if (!citaRepository.existsById(idCita)) {
            throw new ResourceNotFoundException("Cita con Id " + idCita + " no encontrado");
        }
        citaRepository.deleteById(idCita);
    }
}
