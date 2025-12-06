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

import com.br.mobility.mobility.domain.repository.MotoristaRepository;
import com.br.mobility.mobility.domain.repository.PassageiroRepository;

@Configuration
public class Security {

  @Bean
  public UserDetailsService userDetailsService(PassageiroRepository passageiroRepo, MotoristaRepository motoristaRepo) {
    return username -> {
      return passageiroRepo.findByEmail(username)
          .map(passageiro -> org.springframework.security.core.userdetails.User
              .withUsername(passageiro.getEmail())
              .password(passageiro.getSenha()) // precisa estar BCRYPT
              .roles("PASSAGEIRO")
              .build())
          .or(() -> motoristaRepo.findByEmail(username)
              .map(motorista -> org.springframework.security.core.userdetails.User
                  .withUsername(motorista.getEmail())
                  .password(motorista.getSenha())
                  .roles("MOTORISTA")
                  .build()))
          .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
    };
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
            .requestMatchers(HttpMethod.POST, "/motorista/cadastrar").permitAll()
            .requestMatchers("/motorista/**").hasRole("MOTORISTA")
            .requestMatchers("/passageiro/**").hasRole("PASSAGEIRO")
            .anyRequest().authenticated())
        .httpBasic(b -> {
        })
        .build();
  }
}
