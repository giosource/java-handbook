package com.br.ecommerce.ecommerce.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.br.ecommerce.ecommerce.Repositories.UsuarioRepository;

@Configuration
public class Security {

    @Bean
    public UserDetailsService userDetailsService(UsuarioRepository repo) {
        return username -> repo.findByEmail(username)
        .map(usuario -> org.springframework.security.core.userdetails.User
        .withUsername(usuario.getEmail())
        .password(usuario.getSenha()) // precisa estar BCRYPT
        .roles("USER") // vira ROLE_USER
        .build())
        .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
        .csrf(csrf -> csrf.disable())
        .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .authorizeHttpRequests(auth -> auth
        .requestMatchers(
        "/v3/api-docs",
        "/v3/api-docs/**",
        "/v3/api-docs/swagger-config",
        "/swagger-ui.html",
        "/swagger-ui/**",
        "/swagger-resources",
        "/swagger-resources/**",
        "/webjars/**")
        .permitAll()
        .requestMatchers(HttpMethod.POST, "/usuario/salvar").permitAll()
        .anyRequest().authenticated())
        .httpBasic(b -> {
        })
        .build();
    }
}