package com.board.gustmd.global.security;

import com.board.gustmd.global.security.exception.handler.JwtExceptionHandler;
import com.board.gustmd.global.security.filter.JwtFilter;
import com.board.gustmd.global.security.jwt.JwtTokenProvider;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsUtils;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final JwtTokenProvider jwtTokenProvider;
    private final ObjectMapper objectMapper;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .formLogin().disable()
                .cors().disable()

                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .and()
                .authorizeRequests()
                .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()

                .antMatchers(HttpMethod.GET,"/board").permitAll()
                .antMatchers(HttpMethod.GET,"/board/*").authenticated()
                .antMatchers(HttpMethod.POST,"/board").permitAll()
                .antMatchers(HttpMethod.DELETE,"/board/*").authenticated()
                .antMatchers(HttpMethod.PUT,"/board/*").authenticated()
                .antMatchers(HttpMethod.POST,"/account/*").permitAll()
                .antMatchers(HttpMethod.PATCH,"/account/refresh").permitAll()
                .antMatchers(HttpMethod.PATCH,"/account/logout").authenticated()
                .antMatchers(HttpMethod.POST,"account/withdrawal").authenticated ()

                .anyRequest().denyAll()
                .and()

                .exceptionHandling().authenticationEntryPoint(new CustomAuthenticationEntryPoint(objectMapper))
                .and()

                .addFilterAfter(new JwtFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(new JwtExceptionHandler(objectMapper),UsernamePasswordAuthenticationFilter.class);
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}

