package com.github.reneranzinger.bicycledatabase.testing.qualifier;

import org.springframework.stereotype.Component;

@Component("simpleTwo")
public class SimpleTwo implements SimpleInterface
{

    public String format()
    {
        return "Two";
    }
}