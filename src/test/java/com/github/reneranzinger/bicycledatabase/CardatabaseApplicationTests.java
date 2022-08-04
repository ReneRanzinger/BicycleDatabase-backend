package com.github.reneranzinger.bicycledatabase;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.github.reneranzinger.bicycledatabase.controllers.BicycleController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CardatabaseApplicationTests
{
    @Autowired
    private BicycleController m_controller;

    @Test
    public void contextLoads()
    {
        assertThat(this.m_controller).isNotNull();
    }

}
