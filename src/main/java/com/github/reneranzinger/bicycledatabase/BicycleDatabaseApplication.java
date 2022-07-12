package com.github.reneranzinger.bicycledatabase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.github.reneranzinger.bicycledatabase.persist.Bicycle;
import com.github.reneranzinger.bicycledatabase.persist.BicycleRepository;
import com.github.reneranzinger.bicycledatabase.persist.Owner;
import com.github.reneranzinger.bicycledatabase.persist.OwnerRepository;

@SpringBootApplication
public class BicycleDatabaseApplication
{
    @Autowired
    private BicycleRepository m_repositoryBicycle;
    @Autowired
    private OwnerRepository m_repositoryOwner;

    public static void main(String[] args)
    {
        SpringApplication.run(BicycleDatabaseApplication.class, args);
    }

    @Bean
    CommandLineRunner runner()
    {
        return args -> {
            Owner t_owner1 = new Owner("John", "Doe");
            Owner t_owner2 = new Owner("Jane", "Doe");
            this.m_repositoryOwner.save(t_owner1);
            this.m_repositoryOwner.save(t_owner2);

            this.m_repositoryBicycle.save(
                    new Bicycle("Ford", "Mustang", "Red", "ADF-1121", 2017, 59000D, t_owner1));
            this.m_repositoryBicycle.save(
                    new Bicycle("Nissan", "Leaf", "White", "SSJ-3002", 2014, 29000D, t_owner1));
            this.m_repositoryBicycle.save(
                    new Bicycle("Toyota", "Prius", "Silver", "KKO-0212", 2018, 39000D, t_owner2));
            List<Bicycle> a = this.m_repositoryBicycle.findByBrand("Nissan");
            System.out.println("Found: " + a.size());
        };
    }

}
