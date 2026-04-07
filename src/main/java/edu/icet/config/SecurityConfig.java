package edu.icet.config;

import edu.icet.security.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)

                .cors(cors -> cors.configurationSource(request -> {
                    CorsConfiguration config = new CorsConfiguration();
                    config.setAllowedOrigins(Arrays.asList(
                            "http://localhost:5173",
                            "http://localhost:3000",
                            "http://localhost:8080"
                    ));
                    config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
                    config.setAllowedHeaders(Arrays.asList("*"));
                    config.setAllowCredentials(true);
                    config.setMaxAge(3600L);
                    return config;
                }))

                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                .authorizeHttpRequests(auth -> auth
                        // Public endpoints
                        .requestMatchers(
                                "/users/login",
                                "/users/register",
                                "/error",
                                "/v3/api-docs/**",
                                "/swagger-ui/**",
                                "/swagger-ui.html"
                        ).permitAll()


                        .requestMatchers(HttpMethod.GET, "/courses/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/courses/**").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/courses/**").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/courses/**").hasAuthority("ADMIN")


                        .requestMatchers("/users/admin/**").hasAuthority("ADMIN")
                        .requestMatchers("/users/teacher/**").hasAnyAuthority("ADMIN", "TEACHER")
                        .requestMatchers("/users/student/**").hasAnyAuthority("ADMIN", "TEACHER", "STUDENT", "PARENT")
                        .requestMatchers("/users/parent/**").hasAnyAuthority("ADMIN", "PARENT")


                        .requestMatchers(HttpMethod.POST, "/users/add").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/users/delete/**").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/users/update-user").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/users/get-all").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/users/*/role").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/users/*/activate").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/users/*/deactivate").hasAuthority("ADMIN")


                        .requestMatchers(HttpMethod.GET, "/users/*").authenticated()
                        .requestMatchers(HttpMethod.PUT, "/users/*/password").authenticated()


                        .anyRequest().authenticated()
                )

                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}