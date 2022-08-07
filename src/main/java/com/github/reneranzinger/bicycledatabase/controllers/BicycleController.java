package com.github.reneranzinger.bicycledatabase.controllers;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.reneranzinger.bicycledatabase.persist.Bicycle;
import com.github.reneranzinger.bicycledatabase.persist.BicycleRepository;

@RestController
@RequestMapping("/api/own")
public class BicycleController
{
    @Autowired
    private BicycleRepository m_repositoryBicycle;

    @RequestMapping(value = "/bicycles", method = RequestMethod.GET)
    public Iterable<Bicycle> getBicycles()
    {
        throw new EntityNotFoundException();
        // return this.m_repositoryBicycle.findAll();
    }
}
