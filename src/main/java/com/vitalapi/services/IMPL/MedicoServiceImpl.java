package com.vitalapi.services.IMPL;

import com.vitalapi.entities.Cita;
import com.vitalapi.entities.Disponibilidad;
import com.vitalapi.entities.Medico;
import com.vitalapi.repository.CitaRepository;
import com.vitalapi.repository.DTO.MedicoDTO;
import com.vitalapi.repository.MedicoRepository;
import com.vitalapi.services.DisponibilidadService;
import com.vitalapi.services.MedicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicoServiceImpl implements MedicoService {

    private final MedicoRepository medicoRepository;
    private final DisponibilidadService disponibilidadService;
    private final CitaRepository citaRepository;

    @Override
    public List<Medico> obtenerMedicos() {
        return medicoRepository.findAll();
    }

    @Override
    public List<MedicoDTO> obtenerMedicosconDisponibilidad() {
        List<Medico> medicos = medicoRepository.findAll();
        List<MedicoDTO> medicosDTO = new ArrayList<>();
        for (Medico medico : medicos) {
            Disponibilidad disponibilidad = disponibilidadService.obtenerDisponibilidadPorId(medico.getNumeroDocumento());
            MedicoDTO medicoDTO = new MedicoDTO();
            medicoDTO.setNumeroDocumento(medico.getNumeroDocumento());
            medicoDTO.setNombres(medico.getNombres());
            medicoDTO.setApellidos(medico.getApellidos());
            medicoDTO.setEspecialidad(medico.getEspecialidad());
            medicoDTO.setDisponibilidadFinal(disponibilidad.getFinDisponibilidad());
            medicosDTO.add(medicoDTO);
        }
        return medicosDTO;
    }

    @Override
    public List<LocalDateTime> obtenerFechasDisponiblesMedico(Long numeroDocumento) {
        Disponibilidad disponibilidad = disponibilidadService.obtenerDisponibilidadPorId(numeroDocumento);
        List<Cita> citasTomadas = citaRepository.findByDocumentoMedico(numeroDocumento);
        List<LocalDateTime> fechasDisponibles = new ArrayList<>();
        LocalDateTime inicio = disponibilidad.getInicioDisponibilidad();
        LocalDateTime fin =  disponibilidad.getFinDisponibilidad();
        while(!inicio.isAfter(fin)) {
            if(!citasTomadas.contains(inicio)) {
                fechasDisponibles.add(inicio);
            }
            inicio = inicio.plusMinutes(15);
        }
        return fechasDisponibles;
    }

    @Override
    public Medico obtenerMedicoPorId(Long numeroDocumento) {
        return medicoRepository.findById(numeroDocumento).orElse(null);
    }

    @Override
    public Medico registrarMedico(Medico medico) {
        return medicoRepository.save(medico);
    }

    @Override
    public void eliminarMedico(Long numeroDocumento) {
        medicoRepository.deleteById(numeroDocumento);
    }

    @Override
    public Medico actualizarMedico(Long numeroDocumento, Medico medico) {
        Medico medicoDB = medicoRepository.findById(numeroDocumento).orElse(null);
        if (medicoDB != null) {
            medicoDB.setNombres(medico.getNombres());
            medicoDB.setApellidos(medico.getApellidos());
            medicoDB.setTipoDocumento(medico.getTipoDocumento());
            medicoDB.setCorreo(medico.getCorreo());
            medicoDB.setTelefono(medico.getTelefono());
            medicoDB.setBarrio(medico.getBarrio());
            medicoDB.setEspecialidad(medico.getEspecialidad());
            if (medico.getContrasena() != null && !medico.getContrasena().isEmpty()) {
                medicoDB.setContrasena(medico.getContrasena());
            }
            return medicoRepository.save(medicoDB);
        }
        return null;
    }
}
