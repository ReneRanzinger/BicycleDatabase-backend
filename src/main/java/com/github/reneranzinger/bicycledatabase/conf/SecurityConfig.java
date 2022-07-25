package com.github.reneranzinger.bicycledatabase.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfig
{
    // @Autowired
    // AuthenticationManager m_manager;
    //
    // @Bean
    // public AuthenticationManager authenticationManager(
    // final AuthenticationConfiguration authenticationConfiguration) throws
    // Exception
    // {
    // return authenticationConfiguration.getAuthenticationManager();
    // }
    //
    // @Autowired
    // private UserDetailServiceImpl m_userDetailsService;
    //
    // @Autowired
    // public void configureGlobal(AuthenticationManagerBuilder
    // a_authManagerBuilder) throws Exception
    // {
    // a_authManagerBuilder.userDetailsService(this.m_userDetailsService)
    // .passwordEncoder(new BCryptPasswordEncoder());
    // }
    //
    // @Autowired
    // protected void configure(HttpSecurity http) throws Exception
    // {
    // http.csrf().disable().cors().and().authorizeRequests()
    // .antMatchers(HttpMethod.POST,
    // "/login").permitAll().anyRequest().authenticated()
    // .and()
    // // Filter for the api/login requests
    // .addFilterBefore(new LoginFilter("/login", this.m_manager),
    // UsernamePasswordAuthenticationFilter.class)
    // // Filter for other requests to check JWT in header
    // .addFilterBefore(new AuthenticationFilter(),
    // UsernamePasswordAuthenticationFilter.class);
    // }
    //
    // @Bean
    // public CorsConfigurationSource corsConfigurationSource()
    // {
    // UrlBasedCorsConfigurationSource source = new
    // UrlBasedCorsConfigurationSource();
    // CorsConfiguration config = new CorsConfiguration();
    // config.setAllowedOrigins(Arrays.asList("*"));
    // config.setAllowedMethods(Arrays.asList("*"));
    // config.setAllowedHeaders(Arrays.asList("*"));
    // config.setAllowCredentials(true);
    // config.applyPermitDefaultValues();
    //
    // source.registerCorsConfiguration("/**", config);
    // return source;
    // }
}
