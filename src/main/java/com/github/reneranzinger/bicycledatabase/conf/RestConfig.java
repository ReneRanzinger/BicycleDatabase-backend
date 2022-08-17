package com.github.reneranzinger.bicycledatabase.conf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class RestConfig implements RepositoryRestConfigurer
{
    private static final Logger logger = LoggerFactory.getLogger(RestConfig.class);

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration a_restConfig,
            CorsRegistry a_cors)
    {
        logger.info("RestConfig::configureREpositoryREstConfiguration");
        a_restConfig.setBasePath("/api");
    }
}