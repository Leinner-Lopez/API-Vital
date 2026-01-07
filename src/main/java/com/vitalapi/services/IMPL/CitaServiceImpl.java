package com.vitalapi.services.IMPL;

import com.vitalapi.entities.Cita;
import com.vitalapi.entities.Medico;
import com.vitalapi.entities.Paciente;
import com.vitalapi.repository.CitaRepository;
import com.vitalapi.repository.DTO.CitaDTO;
import com.vitalapi.services.CitaService;
import com.vitalapi.services.MedicoService;
import com.vitalapi.services.PacienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CitaServiceImpl implements CitaService {
    private final PacienteService pacienteService;
    private final MedicoService medicoService;
    private final CitaRepository citaRepository;


    @Override
    public List<CitaDTO> CitasDocumentoPaciente(Long numeroDocumento) {
        List<Cita> citas = citaRepository.findByDocumentoPaciente(numeroDocumento);
        List<CitaDTO> resultado = new ArrayList<>();
        for (Cita cita : citas) {
            Paciente paciente = pacienteService.obtenerPacientePorId(cita.getDocumentoPaciente());
            Medico medico = medicoService.obtenerMedicoPorId(cita.getDocumentoMedico());
            CitaDTO citadto = new CitaDTO();
            citadto.setId(cita.getId());
            citadto.setNombrePaciente(paciente.getNombres() + " " + paciente.getApellidos());
            citadto.setNombreMedico(medico.getNombres() + " " + medico.getApellidos());
            citadto.setEspecialidadMedico(medico.getEspecialidad());
            citadto.setFechaCita(cita.getFechaCita());
            resultado.add(citadto);
        }
        return resultado;
    }

    @Override
    public List<CitaDTO> CitasDocumentoMedico(Long numeroDocumento) {
        List<Cita> citas = citaRepository.findByDocumentoMedico(numeroDocumento);
        List<CitaDTO> resultado = new ArrayList<>();
        for (Cita cita : citas) {
            Paciente paciente = pacienteService.obtenerPacientePorId(cita.getDocumentoPaciente());
            Medico medico = medicoService.obtenerMedicoPorId(cita.getDocumentoMedico());
            CitaDTO citadto = new CitaDTO();
            citadto.setId(cita.getId());
            citadto.setNombrePaciente(paciente.getNombres() + " " + paciente.getApellidos());
            citadto.setNombreMedico(medico.getNombres() + " " + medico.getApellidos());
            citadto.setEspecialidadMedico(medico.getEspecialidad());
            citadto.setFechaCita(cita.getFechaCita());
            resultado.add(citadto);
        }
        return resultado;
    }

    @Override
    public List<CitaDTO> ListarCitasMedicas() {
        List<Cita> citas = citaRepository.findAll();
        List<CitaDTO> citasDTO = new ArrayList<>();
        for (Cita cita : citas) {
            Paciente paciente = pacienteService.obtenerPacientePorId(cita.getDocumentoPaciente());
            Medico medico = medicoService.obtenerMedicoPorId(cita.getDocumentoMedico());
            CitaDTO citadto = new CitaDTO();
            citadto.setId(cita.getId());
            citadto.setNombrePaciente(paciente.getNombres() + " " + paciente.getApellidos());
            citadto.setNombreMedico(medico.getNombres() + " " + medico.getApellidos());
            citadto.setEspecialidadMedico(medico.getEspecialidad());
            citadto.setFechaCita(cita.getFechaCita());
            citasDTO.add(citadto);
        }
        return citasDTO;
    }

    @Override
    public void eliminarCita(Long id) {
        citaRepository.deleteById(id);
    }

    @Override
    public Cita agendarCita(Cita cita) {
        return citaRepository.save(cita);
    }

    @Override
    public Cita obtenerCitaporId(Long id) {
        return citaRepository.findById(id).orElse(null);
    }

    @Override
    public Cita ReprogramarCita(Long id, Cita cita) {
        Cita citaExistente = citaRepository.findById(id).orElse(null);
        if (citaExistente != null) {
            citaExistente.setFechaCita(cita.getFechaCita());
            citaRepository.save(citaExistente);
        }
        return null;
    }
}
