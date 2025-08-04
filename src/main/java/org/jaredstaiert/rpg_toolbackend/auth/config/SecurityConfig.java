package org.jaredstaiert.rpg_toolbackend.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Enable OAuth2 login via Auth0 using new lambda config
                .oauth2Login(withDefaults())
                // Session management (default session fixation protection applies)
                .sessionManagement(session -> session
                        .sessionFixation(sessionFixation -> sessionFixation.migrateSession())
                )
                // CSRF protection: disable for API endpoints if using AJAX (customize as needed)
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers("/auth/**")
                )

                // New method for authorization
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth/login").authenticated()
                        .requestMatchers("/auth/**").authenticated()
                        .anyRequest().permitAll()
                )

                // Logout configuration
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                )

                // CORS configuration (if needed, for SPA on different origin)
                .cors(withDefaults());

        return http.build();
    }

}
