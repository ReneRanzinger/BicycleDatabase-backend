package com.github.reneranzinger.bicycledatabase.testing.qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class SimpleService
{
    @Autowired
    @Qualifier("simpleOne")
    private SimpleInterface m_simple;
}
