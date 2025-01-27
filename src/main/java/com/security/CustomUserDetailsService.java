package com.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) {
        // Aquí debes consultar a tu base de datos para obtener el usuario.
        // Esto es solo un ejemplo:
        return User.builder()
                .username("admin")
                .password("{noop}admin123") // Noop para no encriptar la contraseña en este ejemplo
                .roles("USER")
                .build();
    }
}
