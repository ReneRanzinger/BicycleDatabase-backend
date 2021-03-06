package com.github.reneranzinger.bicycledatabase.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.reneranzinger.bicycledatabase.persist.Bicycle;
import com.github.reneranzinger.bicycledatabase.persist.BicycleRepository;

@RestController
public class BicycleController
{
    @Autowired
    private BicycleRepository m_repositoryBicycle;

    @RequestMapping(value = "/bicycles", method = RequestMethod.GET)
    public Iterable<Bicycle> getBicycles()
    {
        return this.m_repositoryBicycle.findAll();
    }
}
