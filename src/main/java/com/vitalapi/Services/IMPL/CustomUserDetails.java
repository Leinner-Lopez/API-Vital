package com.vitalapi.Services.IMPL;

import com.vitalapi.Entities.Usuario;
import com.vitalapi.Exceptions.Class.ResourceNotFoundException;
import com.vitalapi.Repositories.AdministradorRepository;
import com.vitalapi.Repositories.MedicoRepository;
import com.vitalapi.Repositories.PacienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomUserDetails implements UserDetailsService {
    private final MedicoRepository medicoRepository;
    private final PacienteRepository pacienteRepository;
    private final AdministradorRepository administradorRepository;

    @Override
    public Usuario loadUserByUsername(String username) throws UsernameNotFoundException {

        Long numeroDocumento = Long.parseLong(username);
        //Se busca el Usuario en las 3 tablas
        return medicoRepository.findById(numeroDocumento).map(u -> (Usuario) u)
                .or(() -> pacienteRepository.findById(numeroDocumento).map(u -> (Usuario) u))
                .or(() -> administradorRepository.findById(numeroDocumento).map(u -> (Usuario) u))
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));
    }
}
