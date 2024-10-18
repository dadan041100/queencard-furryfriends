package com.entjava.furryfriends;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig
{
   private final WrongAuthentication wrongAuthentication;

    public SecurityConfig(WrongAuthentication wrongAuthentication)
    {
        this.wrongAuthentication = wrongAuthentication;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception
    {
        http
                .authorizeHttpRequests((request) -> request
                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults())
                .exceptionHandling()
                .authenticationEntryPoint(wrongAuthentication); // Custom handling for failed login
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService()
    {
        return new InMemoryUserDetailsManager
                (
                User.withUsername("dadan041100")
                        .password("{noop}karina041100")
                        .roles("USER")
                        .build(),
                User.withUsername("jude")
                        .password("{noop}judiepie")
                        .roles("USER")
                        .build(),
                User.withUsername("webyn")
                        .password("{noop}meowmeow")
                        .roles("USER")
                        .build(),
                User.withUsername("joanny")
                        .password("{noop}jgg2926")
                        .roles("USER")
                        .build(),
                User.withUsername("hbmones")
                        .password("{noop}monesfamily0116")
                        .roles("USER")
                        .build(),
                User.withUsername("aomoldez")
                        .password("{noop}queen2004")
                        .roles("USER")
                        .build(),
                User.withUsername("jsunga")
                        .password("{noop}jsunga")
                        .roles("USER")
                        .build()
        );
    }
    @Bean
    public AuthenticationManager authManager(HttpSecurity http) throws Exception
    {
        AuthenticationManagerBuilder authenticationManagerBuilder =
                http.getSharedObject(AuthenticationManagerBuilder.class);
        AuthenticationManager authManager = authenticationManagerBuilder.userDetailsService(userDetailsService()).and().build();

        wrongAuthentication.setAuthenticationManager(authManager);
        return authManager;
    }
}
