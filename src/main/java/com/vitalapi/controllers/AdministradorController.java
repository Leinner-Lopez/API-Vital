package com.vitalapi.controllers;

import com.vitalapi.entities.Administrador;
import com.vitalapi.services.AdministradorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/administrador")
@RequiredArgsConstructor
public class AdministradorController {
    private final AdministradorService administradorService;

    //Listar Administradores
    @GetMapping
    public List<Administrador> listarAdministradores(){
        return administradorService.obtenerAdministradores();
    }

    //Obtener Administrador
    @GetMapping("/{id}")
    public Administrador obtenerAdministradorPorId(@PathVariable Long id){
        return administradorService.obtenerAdministradorPorId(id);
    }

    //Registrar Administrador
    @PostMapping
    public Administrador registrarAdministrador(@RequestBody Administrador administrador) {
        return administradorService.registrarAdministrador(administrador);
    }

    //Eliminar Administrador
    @DeleteMapping("/{id}")
    public void eliminarAdministradorPorId(@PathVariable Long id){
        administradorService.eliminarAdministrador(id);
    }

    //Actualizar Administrador
    @PutMapping
    public Administrador actualizarAdministrador(@RequestBody Administrador administrador) {
        return administradorService.actualizarAdministrador(administrador.getNumeroDocumento(),administrador);
    }


}
