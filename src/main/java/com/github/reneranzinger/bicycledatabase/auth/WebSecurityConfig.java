package com.github.reneranzinger.bicycledatabase.auth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.github.reneranzinger.bicycledatabase.auth.jwt.AuthEntryPointJwt;
import com.github.reneranzinger.bicycledatabase.auth.jwt.AuthTokenFilter;
import com.github.reneranzinger.bicycledatabase.auth.services.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig
{
    private static final Logger logger = LoggerFactory.getLogger(WebSecurityConfig.class);

    @Autowired
    private AuthEntryPointJwt unauthorizedHandler;
    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
    {
        logger.info("WebSecurityConfig::filterChain");
        http.cors().and().csrf().disable().exceptionHandling()
                .authenticationEntryPoint(this.unauthorizedHandler).and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
                .antMatchers("/api/auth/**").permitAll().antMatchers("/api/test/**").permitAll()
                .antMatchers("/api/user/**").permitAll().anyRequest().authenticated();

        // TODO does that need to be a bean?
        http.addFilterBefore(this.authenticationJwtTokenFilter(),
                UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder()
    {
        logger.info("WebSecurityConfig::authenticationJwtTokenFilter");
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthTokenFilter authenticationJwtTokenFilter()
    {
        logger.info("WebSecurityConfig::authenticationJwtTokenFilter");
        return new AuthTokenFilter();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration) throws Exception
    {
        logger.info("WebSecurityConfig::authenticationManager");
        return authenticationConfiguration.getAuthenticationManager();
    }

}
