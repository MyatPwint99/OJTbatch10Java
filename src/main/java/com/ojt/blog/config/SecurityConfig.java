package com.ojt.blog.config;


import com.ojt.blog.bl.service.login.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    LoginService loginService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth
                        .requestMatchers("/register", "/logout").permitAll()
                        .anyRequest().authenticated())
                .formLogin(form ->
                                form.loginPage("/login")
//                                        .usernameParameter("email")
//                                        .passwordParameter("password")
//                                .successForwardUrl("redirect:/home")
                                        .defaultSuccessUrl("/home", true)
                                        .failureForwardUrl("/login?error=true")
                                        .permitAll()
                ).logout(form -> form.permitAll());
        return http.build();
    }
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}