package com.vitalapi.Controllers;


import com.vitalapi.Entities.Paciente;
import com.vitalapi.Repositories.DTO.PacienteDTO;
import com.vitalapi.Services.PacienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paciente")
@RequiredArgsConstructor
public class PacienteController {
    private final PacienteService pacienteService;

    //Registrar Paciente
    @PostMapping
    public Paciente registrarPaciente(@RequestBody Paciente paciente) {
        return pacienteService.registrarPaciente(paciente);
    }

    //Obtener Lista de Pacientes en Formato DTO
    @GetMapping
    public List<PacienteDTO> obtenerPacientes() {
        return pacienteService.obtenerPacientes();
    }

    //Obtener Paciente por ID
    @GetMapping("/{id}")
    public Paciente obtenerPacientePorId(@PathVariable Long id) {
        return pacienteService.obtenerPacientePorId(id);
    }

    //Actualizar Paciente de la Base de Datos
    @PutMapping
    public Paciente actualizarPaciente(@RequestBody Paciente paciente) {
        return pacienteService.actualizarPaciente(paciente.getNumeroDocumento(), paciente);
    }

    //Eliminar Paciente de la Base de Datos
    @DeleteMapping("/{id}")
    public void eliminarPaciente(@PathVariable Long id) {
        pacienteService.eliminarPaciente(id);
    }
}
