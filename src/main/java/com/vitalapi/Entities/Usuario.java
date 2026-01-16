package com.vitalapi.Entities;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@MappedSuperclass
@Data
public abstract class Usuario implements UserDetails {
    @Id
    protected Long numeroDocumento;
    protected String nombres;
    protected String apellidos;
    protected String tipoDocumento;
    protected String correo;
    protected String telefono;
    protected String barrio;
    protected String contrasena;

    @Override
    public String getPassword() {
        return contrasena;
    }

    @Override
    public String getUsername() {
        return numeroDocumento + "";
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + this.getClass().getSimpleName().toUpperCase()));
    }
}
