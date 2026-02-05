package com.vitalapi.Controllers;


import com.vitalapi.Enums.EstadoCita;
import com.vitalapi.Repositories.DTO.CitaRequestDTO;
import com.vitalapi.Repositories.DTO.CitaResponseDTO;
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
    public CitaResponseDTO agendarCita(@RequestBody CitaRequestDTO cita) {
        return citaService.agendarCita(cita);
    }

    @GetMapping
    public List<CitaResponseDTO> obtenerCitas() {
        return citaService.obtenerCitas();
    }

    @GetMapping("/cita")
    public List<CitaResponseDTO> obtenerCitasPorEstado(@RequestParam EstadoCita estado) {
        return citaService.obtenerCitasPorEstado(estado);
    }

    @GetMapping("/medico/{id}")
    public List<CitaResponseDTO> obtenerCitasMedico(@PathVariable Long id) {
        return citaService.obtenerCitasMedicoNumeroDocumento(id);
    }

    @GetMapping("/medico/{id}/estado")
    public List<CitaResponseDTO> obtenerCitasMedicoPorEstado(@PathVariable Long id, @RequestParam EstadoCita estado) {
        return citaService.obtenerCitasMedicoPorEstado(id, estado);
    }

    @GetMapping("/paciente/{id}")
    public List<CitaResponseDTO> obtenerCitasPaciente(@PathVariable Long id) {
        return citaService.obtenerCitasPaciente(id);
    }

    @GetMapping("/paciente/{id}/estado")
    public List<CitaResponseDTO> obtenerCitasPacientePorEstado(@PathVariable Long id, @RequestParam EstadoCita estado) {
        return citaService.obtenerCitasPacientePorEstado(id, estado);
    }

    @PutMapping("/{id}")
    public void actualizarCita(@PathVariable Long id, @RequestBody EstadoCita estadoCita) {
        citaService.actualizarEstadoCita(id, estadoCita);
    }

    @DeleteMapping("/{id}")
    public void eliminarCita(@PathVariable Long id) {
        citaService.eliminarCita(id);
    }
}
