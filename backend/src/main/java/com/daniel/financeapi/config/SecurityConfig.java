package com.daniel.financeapi.config;
import com.daniel.financeapi.security.JwtAuthFilter;
import com.daniel.financeapi.security.JwtUtil;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {
    private final JwtUtil jwtUtil;

    public SecurityConfig(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        JwtAuthFilter jwtAuthFilter = new JwtAuthFilter(jwtUtil);
        http.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class).csrf(csrf -> csrf.disable()).authorizeHttpRequests(auth -> auth.requestMatchers("/register", "/login").permitAll().anyRequest().authenticated());
        return http.build();
    }
}
