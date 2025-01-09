package com.example.hello_world.config;

import com.example.hello_world.entity.Role;
import com.example.hello_world.jwt.AuthEntryPoint;
import com.example.hello_world.jwt.JwtAuthenticationFilter;
import com.example.hello_world.security.CustomAuthenticationFailureHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    /*
        @Autowired
        private CustomAuthenticationFailureHandler authenticationFailureHandler;

      @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.inMemoryAuthentication()
                    .withUser("testKullanici")
                    .password(passwordEncoder().encode("testSifre"))
                    .roles("USER");
        }
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .csrf().disable()
                    .authorizeRequests()
                    .antMatchers("/api/**").authenticated()
                    .anyRequest().permitAll()
                    .and()
                    .formLogin()
                    .failureHandler(authenticationFailureHandler)
                    .and()
                    .httpBasic();
        }
    */
    public static final String AUTHENTICATE = "/api/auth/authenticate";
    public static final String REGISTER = "/api/auth/register";
    public static final String REFRESH_TOKEN = "/api/auth/refreshToken";
    public static final String ADMIN = "/api/admin/**";
    public static final String USER = "/api/user/**";
    public static final String[] SWAGGER_PATHS = {
            "/swagger-ui.html",
            "/v3/api-docs/**",
            "/swagger-ui/**",
    };

    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Autowired
    private AuthEntryPoint authEntryPoint;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests(request ->
                        request.antMatchers(AUTHENTICATE, REGISTER, REFRESH_TOKEN).permitAll()
                                .antMatchers(SWAGGER_PATHS).permitAll()
                                .antMatchers(ADMIN).hasAuthority(Role.ADMIN.name())
                                .antMatchers(USER).hasAnyAuthority(Role.ADMIN.name(), Role.USER.name())
                                .anyRequest()
                                .authenticated())
                .exceptionHandling(exception -> exception.authenticationEntryPoint(authEntryPoint))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

}