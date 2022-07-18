package com.github.reneranzinger.bicycledatabase.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class RestConfig implements RepositoryRestConfigurer
{

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration restConfig,
            CorsRegistry cors)
    {
        restConfig.setBasePath("/api");
    }
}