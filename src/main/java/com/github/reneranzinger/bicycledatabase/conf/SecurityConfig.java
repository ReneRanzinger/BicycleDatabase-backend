package com.github.reneranzinger.bicycledatabase.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.github.reneranzinger.bicycledatabase.service.UserDetailServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
    @Autowired
    private UserDetailServiceImpl m_userDetailsService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder a_authManagerBuilder) throws Exception
    {
        a_authManagerBuilder.userDetailsService(this.m_userDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }
}
