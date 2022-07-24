package com.github.reneranzinger.bicycledatabase.testing.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfiguration
{
    @Bean(name = "aluminiumFrame")
    public Material aluminium()
    {
        return new Material("Aluminum");
    }

    @Bean(name = "carbonFrame")
    public Material carbon()
    {
        return new Material("Carbon");
    }
}
