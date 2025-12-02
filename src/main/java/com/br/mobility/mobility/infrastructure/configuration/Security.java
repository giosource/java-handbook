package com.br.mobility.mobility.infrastructure.configuration;

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

import com.br.mobility.mobility.domain.repository.PassageiroRepository;

@Configuration
public class Security {

        @Bean
        public UserDetailsService userDetailsService(PassageiroRepository repo) {
                return username -> repo.findByEmail(username)
                                .map(passageiro -> org.springframework.security.core.userdetails.User
                                                .withUsername(passageiro.getEmail())
                                                .password(passageiro.getSenha()) // precisa estar BCRYPT
                                                .roles("USER") // vira ROLE_USER
                                                .build())
                                .orElseThrow(() -> new UsernameNotFoundException("Passageiro não encontrado"));
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
                                                .requestMatchers(HttpMethod.POST, "/passageiro/cadastrar").permitAll()
                                                .anyRequest().authenticated())
                                .httpBasic(b -> {
                                })
                                .build();
        }
}
