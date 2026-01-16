package com.vitalapi.Controllers;


import com.vitalapi.Enums.EstadoCita;
import com.vitalapi.Repositories.DTO.CitaDTO;
import com.vitalapi.Services.CitaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/citas")
@RequiredArgsConstructor
public class CitaController {
    private final CitaService citaService;

    //Agendar Cita Médica
    @PostMapping
    public CitaDTO agendarCita(@RequestBody CitaDTO cita){
        return citaService.agendarCita(cita);
    }

    @GetMapping
    public List<CitaDTO> obtenerCitas(){
        return citaService.obtenerCitas();
    }

    @GetMapping("/aceptadas/{id}")
    public List<CitaDTO> obtenerCitasAceptadas(@PathVariable Long id){
        return citaService.obtenerCitasAceptadas(id);
    }

    @GetMapping("/completadas/{id}")
    public List<CitaDTO> obtenerCitasCompletadas(@PathVariable Long id){
        return citaService.obtenerCitasCompletadas(id);
    }

    @GetMapping("/pendientes/{id}")
    public List<CitaDTO> obtenerCitasPendientes(@PathVariable Long id){
        return citaService.obtenerCitasPendientes(id);
    }

    @GetMapping("/paciente/{id}")
    public List<CitaDTO> obtenerCitasPaciente(@PathVariable Long id){
        return citaService.obtenerCitasPaciente(id);
    }

    @PutMapping("/{id}")
    public void actualizarCita(@PathVariable Long id, @RequestParam(value = "estado") EstadoCita estadoCita){
        citaService.actualizarEstadoCita(id, estadoCita);
    }

    @DeleteMapping("/{id}")
    public void eliminarCita(@PathVariable Long id){
        citaService.eliminarCita(id);
    }
}
