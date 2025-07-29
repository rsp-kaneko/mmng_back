package com.example.mmng_back.security;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.web.cors.CorsConfiguration;

@EnableWebSecurity
@EnableMethodSecurity
@Configuration
public class WebSecurityConfig {
	
	@Bean
	protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			.csrf(csrf -> csrf
					.csrfTokenRepository(this.csrfTokenRepository())
					.ignoringRequestMatchers("/csrf", "/api/login")
			)
			.headers(headers -> headers
					.frameOptions(frameOptions -> frameOptions.sameOrigin())
			)
			.cors(cors -> cors
					.configurationSource(request -> {
						CorsConfiguration configuration = new CorsConfiguration();
						configuration.setAllowedOrigins(List.of("http://localhost:3000"));
						configuration.setAllowedMethods(List.of("*"));
						configuration.setAllowedHeaders(List.of("*"));
						configuration.setAllowCredentials(true);
						return configuration;
					})
			);
		return http.build();	
	}
	
	@Bean
	protected CsrfTokenRepository csrfTokenRepository() {
		HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
		repository.setParameterName("_csrf");
		repository.setHeaderName("X-CSRF-TOKEN");
		return repository;
	}
	
	@Bean
	protected PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
