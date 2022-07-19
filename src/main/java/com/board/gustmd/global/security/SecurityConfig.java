package com.board.gustmd.global.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.cors.CorsUtils;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .cors().disable()

                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .and()
                .authorizeRequests()
                .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()

                .antMatchers(HttpMethod.GET,"/board").authenticated()
                .antMatchers(HttpMethod.GET,"/board/*").authenticated()
                .antMatchers(HttpMethod.POST,"/board").authenticated()
                .antMatchers(HttpMethod.DELETE,"/board/*").authenticated()
                .antMatchers(HttpMethod.PUT,"/board/*").authenticated()
                .antMatchers(HttpMethod.POST,"/account/*").permitAll()
                .antMatchers(HttpMethod.PATCH,"/account/*").permitAll()

                .anyRequest().denyAll();
    }
}

