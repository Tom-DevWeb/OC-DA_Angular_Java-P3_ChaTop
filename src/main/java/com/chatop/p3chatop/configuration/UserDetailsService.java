package com.chatop.p3chatop.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class UserDetailsService {


    private final JWTConfig jwtConfig;

    public UserDetailsService(JWTConfig JWTConfig) {
        jwtConfig = JWTConfig;
    }

    @Bean
    public org.springframework.security.core.userdetails.UserDetailsService users() {
        UserDetails user =
                User.builder()
                        .username("user")
                        .password(jwtConfig.passwordEncoder().encode("password"))
                        .build();
        return new InMemoryUserDetailsManager(user);
    }
}
