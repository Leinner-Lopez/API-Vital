package com.vitalapi.Services.IMPL;

import com.vitalapi.Entities.Medico;
import com.vitalapi.Exceptions.Class.ResourceDuplicateException;
import com.vitalapi.Exceptions.Class.ResourceNotFoundException;
import com.vitalapi.Mappers.MedicoMapper;
import com.vitalapi.Repositories.DTO.MedicoDTO;
import com.vitalapi.Repositories.MedicoRepository;
import com.vitalapi.Services.MedicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MedicoServiceImpl implements MedicoService {

    private final MedicoRepository medicoRepository;
    private final MedicoMapper medicoMapper;


    @Override
    public Medico registrarMedico(Medico medico) {
        if(medicoRepository.existsByNumeroDocumento(medico.getNumeroDocumento())) {
            throw new ResourceDuplicateException("El medico con el Numero de Documento: " + medico.getNumeroDocumento()+ " ya existe");
        }
        return medicoRepository.save(medico);
    }

    @Override
    public List<MedicoDTO> obtenerMedicos() {
        return medicoRepository.findAll()
                .stream()
                .map(medicoMapper::medicoToMedicoDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Medico obtenerMedicoPorId(Long numeroDocumento) {
        return medicoRepository.findById(numeroDocumento).orElseThrow(()-> new ResourceNotFoundException("El medico con Número de Documento: " + numeroDocumento + " no existe"));
    }

    @Override
    public List<MedicoDTO> obtenerMedicosPorEspecialidad(String especialidad) {
        return medicoRepository.findByEspecialidadIgnoreCase(especialidad)
                .stream()
                .map(medicoMapper::medicoToMedicoDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void eliminarMedico(Long numeroDocumento) {
        medicoRepository.deleteById(numeroDocumento);
    }

    @Override
    public Medico actualizarMedico(Long numeroDocumento, Medico medico) {
        Medico medicoDB = obtenerMedicoPorId(numeroDocumento);
        medicoDB.setNombres(medico.getNombres());
        medicoDB.setApellidos(medico.getApellidos());
        medicoDB.setTipoDocumento(medico.getTipoDocumento());
        medicoDB.setCorreo(medico.getCorreo());
        medicoDB.setTelefono(medico.getTelefono());
        medicoDB.setBarrio(medico.getBarrio());
        medicoDB.setEspecialidad(medico.getEspecialidad());
        if(!medicoDB.getContrasena().equals(medico.getContrasena())){
            medicoDB.setContrasena(medico.getContrasena());
        }
        return medicoRepository.save(medicoDB);
    }
}
