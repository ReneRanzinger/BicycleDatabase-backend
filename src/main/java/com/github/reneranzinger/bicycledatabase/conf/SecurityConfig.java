package com.github.reneranzinger.bicycledatabase.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{

    @Override
    protected void configure(HttpSecurity a_http) throws Exception
    {
        // TODO Auto-generated method stub
        super.configure(a_http);
    }

    @Bean
    @Override
    protected UserDetailsService userDetailsService()
    {
        UserDetails t_user = User.withDefaultPasswordEncoder().username("user").password("password")
                .roles("USER").build();
        return new InMemoryUserDetailsManager(t_user);
    }

}
