package com.soporteAtenciones.sistemaAtenciones.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.soporteAtenciones.sistemaAtenciones.auth.JwtAuthenticationFiltrer;

@Configuration
@EnableWebSecurity
public class SecurityConfig {



    // Codificador de contraseñas (BCrypt recomendado)
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Configuración de seguridad HTTP
 @Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http, JwtAuthenticationFiltrer jwtFilter) throws Exception {
  http
    .csrf(csrf -> csrf.disable())
    .cors(cors -> {}) // 👈 Esto activa tu CorsConfig
    .authorizeHttpRequests(auth -> auth
        .requestMatchers("/api/auth/**").permitAll()
        .requestMatchers("/api/admin/**").hasRole("ADMIN")
        .anyRequest().authenticated()
    )
    .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);


    return http.build();
}

}