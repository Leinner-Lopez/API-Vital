package com.vitalapi.Controllers;


import com.vitalapi.Entities.Medico;
import com.vitalapi.Repositories.DTO.MedicoDTO;
import com.vitalapi.Services.MedicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medico")
@RequiredArgsConstructor
public class MedicoController {
    private final MedicoService medicoService;

    //Registrar Médico en el Sistema
    @PostMapping
    public Medico registrarMedico(@RequestBody Medico medico) {
        return medicoService.registrarMedico(medico);
    }

    //Obtener Medicos de la base de datos pero en formato DTO
    @GetMapping
    public List<MedicoDTO> obtenerMedicos() {
        return medicoService.obtenerMedicos();
    }

    //Obtener Médico por ID
    @GetMapping("/{id}")
    public Medico obtenerMedicoPorId(@PathVariable Long id) {
        return medicoService.obtenerMedicoPorId(id);
    }

    //Obtener Médicos según la Especialidad
    @GetMapping("/medicos")
    public List<MedicoDTO> obtenerMedicosPorEspecialidad(@RequestParam(value = "especialidad") String especialidad) {
        return medicoService.obtenerMedicosPorEspecialidad(especialidad);
    }

    //Actualizar Médico de la base de datos
    @PutMapping
    public Medico actualizarMedico(@RequestBody Medico medico) {
        return medicoService.actualizarMedico(medico.getNumeroDocumento(), medico);
    }

    //Eliminar Médico de la Base de Datos
    @DeleteMapping("/{id}")
    public void eliminarMedico(@PathVariable Long id) {
        medicoService.eliminarMedico(id);
    }
}
