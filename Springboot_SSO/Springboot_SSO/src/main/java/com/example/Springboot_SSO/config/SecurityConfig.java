package com.example.Springboot_SSO.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/", "/loginPage**").permitAll()
                                .anyRequest().authenticated()
                )
                .csrf(AbstractHttpConfigurer::disable) //.csrf(csrf -> csrf.disable()) ---Lambda can be replaced with method reference
                .oauth2Login(oauth2Login ->
                        oauth2Login
                               // .loginPage("/oauth2/authorization/wso2")
                                .loginPage("/loginPage")  //to display our owm login page and gives links like above to open identity servers(wso2,github ...)
                               .defaultSuccessUrl("/welcome", true)
                               .failureUrl("/error")
                );

        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/resources/**", "/error");
    }
}
