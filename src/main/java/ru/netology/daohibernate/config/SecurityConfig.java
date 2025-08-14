package ru.netology.daohibernate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity(jsr250Enabled = true, securedEnabled = true)
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        var uds = new InMemoryUserDetailsManager();

        var u1 = User.withUsername("read")
                .password(passwordEncoder().encode("read"))
                .roles("READ")
                .build();

        var u2 = User.withUsername("write")
                .password(passwordEncoder().encode("write"))
                .roles("WRITE")
                .build();

        var u3 = User.withUsername("delete")
                .password(passwordEncoder().encode("delete"))
                .roles("DELETE")
                .build();
        var u4 = User.withUsername("admin")
                .password(passwordEncoder().encode("admin"))
                .authorities("search")
                .build();


        uds.createUser(u1);
        uds.createUser(u2);
        uds.createUser(u3);
        uds.createUser(u4);
        return uds;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.formLogin(Customizer.withDefaults());
        http.authorizeHttpRequests(c -> c.requestMatchers("/persons").permitAll()
                .requestMatchers("/persons/by*").hasAuthority("search")
                .anyRequest().authenticated());
        return http.build();
    }
}