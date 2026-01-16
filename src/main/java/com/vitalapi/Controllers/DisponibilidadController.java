package com.vitalapi.Controllers;


import com.vitalapi.Entities.Disponibilidad;
import com.vitalapi.Repositories.DTO.DisponibilidadDTO;
import com.vitalapi.Services.DisponibilidadService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/disponibilidad")
@RequiredArgsConstructor
public class DisponibilidadController {
    private final DisponibilidadService disponibilidadService;

    @PostMapping
    public Disponibilidad registrarDisponibilidad (@RequestBody Disponibilidad disponibilidad){
        return  disponibilidadService.registrarDisponibilidad(disponibilidad);
    }

    @GetMapping("/medico/{id}")
    public List<Disponibilidad> medicoDisponibilidad(@PathVariable Long id){
        return disponibilidadService.obtenerDisponibilidadPorMedico(id);
    }

    @GetMapping("/dia/{id}")
    public List<DisponibilidadDTO> diaDisponibilidad(@PathVariable Long id,
                                                  @RequestParam
                                                  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha){
        return disponibilidadService.consultarDisponibilidadPorDia(id,fecha);
    }

    @DeleteMapping("/{id}")
    public void eliminarDisponibilidad(@PathVariable Long id){
        disponibilidadService.eliminarDisponibilidad(id);
    }
}
