package com.github.reneranzinger.bicycledatabase.testing.qualifier;

import org.springframework.stereotype.Component;

@Component("simpleOne")
public class SimpleOne implements SimpleInterface
{

    public String format()
    {
        return "One";
    }
}