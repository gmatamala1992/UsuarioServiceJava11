package com.usuario.usuarioservice.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {


    @Autowired
    private JwtAuthFilter jwtAuthFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable() // En esta versión se puede usar el estilo directo
                .authorizeRequests() // Cambia de authorizeHttpRequests a authorizeRequests
                .antMatchers("/login").authenticated() // Cambia requestMatchers a antMatchers
                .antMatchers("/consultar").permitAll()
                .antMatchers("/sing-up").permitAll()
                .anyRequest().permitAll()
                .and() // Necesitas volver al contexto principal
                .httpBasic(); // O el tipo de autenticación que estés usando
        return http.build();
    }
}
