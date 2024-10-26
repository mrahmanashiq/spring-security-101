package com.mrahmanashiq.spring_security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@EnableWebSecurity(debug = true)
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        User admin = new User("admin", "{noop}12345",
                List.of(new SimpleGrantedAuthority("ROLE_ADMIN"),
                        new SimpleGrantedAuthority("ADMIN:READ_PERMISSION")));

        User moderator = new User("moderator", "{noop}12345",
                List.of(new SimpleGrantedAuthority("ROLE_MODERATOR"),
                        new SimpleGrantedAuthority("MODERATOR:READ_PERMISSION")));

        User user = new User("user", "{noop}12345",
                List.of(new SimpleGrantedAuthority("ROLE_USER"),
                        new SimpleGrantedAuthority("USER:READ_PERMISSION")));

        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager(admin, moderator, user);

        return userDetailsManager;
    }
}
