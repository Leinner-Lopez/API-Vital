package com.vitalapi.Auth;


import com.vitalapi.Entities.Paciente;
import com.vitalapi.Entities.Usuario;
import com.vitalapi.Services.IMPL.CustomUserDetails;
import com.vitalapi.Services.PacienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final PacienteService pacienteService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final CustomUserDetails userDetails;

    public AuthResponse login(@RequestBody LoginRequest loginRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        Usuario user = userDetails.loadUserByUsername(loginRequest.getUsername());
        String token = jwtService.getToken(user);
        return AuthResponse.builder().token(token).build();
    }

    public AuthResponse register(@RequestBody RegisterRequest registerRequest) {
        Paciente paciente = new Paciente();
        paciente.setNumeroDocumento(registerRequest.getNumeroDocumento());
        paciente.setNombres(registerRequest.getNombres());
        paciente.setApellidos(registerRequest.getApellidos());
        paciente.setTipoDocumento(registerRequest.getTipoDocumento());
        paciente.setCorreo(registerRequest.getCorreo());
        paciente.setTelefono(registerRequest.getTelefono());
        paciente.setBarrio(registerRequest.getBarrio());
        paciente.setContrasena(registerRequest.getContrasena());
        paciente.setSeguroMedico(registerRequest.getSeguroMedico());

        pacienteService.registrarPaciente(paciente);
        return new AuthResponse(jwtService.getToken(paciente));
    }
}
