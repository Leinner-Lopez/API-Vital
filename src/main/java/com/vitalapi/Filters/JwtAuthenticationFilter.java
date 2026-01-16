package com.vitalapi.Filters;

import com.vitalapi.Auth.JwtService;
import com.vitalapi.Entities.Usuario;
import com.vitalapi.Services.IMPL.CustomUserDetails;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Configuration
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final CustomUserDetails customUserDetails;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        final String token = getTokenFromRequest(request);
        final String username;

        if(token == null){
            filterChain.doFilter(request,response);
            return;
        }
        username = jwtService.getUserNameFromToken(token);
        if(username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            Usuario usuario = customUserDetails.loadUserByUsername(username);
            if(jwtService.isTokenValid(token,usuario)){
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(usuario,null, usuario.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }

        filterChain.doFilter(request,response);
    }

    private String getTokenFromRequest(HttpServletRequest request){
        final String authHeader = request.getHeader("Authorization");
        if(StringUtils.hasText(authHeader) && authHeader.startsWith("Bearer ")){
            return authHeader.substring(7);
        }
        return null;
    }
}
