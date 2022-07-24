package com.github.reneranzinger.bicycledatabase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.github.reneranzinger.bicycledatabase.persist.Bicycle;
import com.github.reneranzinger.bicycledatabase.persist.BicycleRepository;
import com.github.reneranzinger.bicycledatabase.persist.Brand;
import com.github.reneranzinger.bicycledatabase.persist.BrandRepository;
import com.github.reneranzinger.bicycledatabase.persist.Owner;
import com.github.reneranzinger.bicycledatabase.persist.OwnerRepository;
import com.github.reneranzinger.bicycledatabase.persist.User;
import com.github.reneranzinger.bicycledatabase.persist.UserRepository;

@SpringBootApplication
public class BicycleDatabaseApplication
{
    @Autowired
    private BicycleRepository m_repositoryBicycle;
    @Autowired
    private OwnerRepository m_repositoryOwner;
    @Autowired
    private BrandRepository m_repositoryBrand;
    @Autowired
    private UserRepository m_repositoryUser;

    public static void main(String[] args)
    {
        ConfigurableApplicationContext t_context = SpringApplication
                .run(BicycleDatabaseApplication.class, args);

        // print all registered bean names
        for (String t_name : t_context.getBeanDefinitionNames())
        {
            // System.out.println(t_name);
        }
    }

    @Bean
    CommandLineRunner runner()
    {
        return args -> {
            Owner t_owner1 = new Owner("John", "Doe");
            Owner t_owner2 = new Owner("Jane", "Doe");
            t_owner1 = this.m_repositoryOwner.save(t_owner1);
            t_owner2 = this.m_repositoryOwner.save(t_owner2);

            Brand t_brand1 = new Brand("Giant");
            Brand t_brand2 = new Brand("Mount");
            t_brand1 = this.m_repositoryBrand.save(t_brand1);
            t_brand2 = this.m_repositoryBrand.save(t_brand2);

            Bicycle t_bike1 = new Bicycle(t_brand1, "Escape", "Red", "ADF-1121", 2017);
            Bicycle t_bike2 = new Bicycle(t_brand1, "City", "White", "SSJ-3002", 2014);
            Bicycle t_bike3 = new Bicycle(t_brand2, "Road", "Silver", "KKO-0212", 2018);
            t_bike1 = this.m_repositoryBicycle.save(t_bike1);
            this.m_repositoryBicycle.save(t_bike2);
            this.m_repositoryBicycle.save(t_bike3);

            // t_owner1.getBicycle().add(t_bike1);
            // this.m_repositoryOwner.save(t_owner1);
            t_bike1.getOwners().add(t_owner1);
            t_bike1.getOwners().add(t_owner2);
            this.m_repositoryBicycle.save(t_bike1);

            // t_bike1.getOwners().remove(t_owner2);
            // t_owner2.getBicycle().remove(t_bike1);
            // this.m_repositoryBicycle.save(t_bike1);

            // List<Bicycle> a = this.m_repositoryBicycle.findByModel("Escape");
            // user : user
            this.m_repositoryUser.save(new User("user",
                    "$2a$04$1.YhMIgNX/8TkCKGFUONWO1waedKhQ5KrnB30fl0Q01QKqmzLf.Zi", "USER"));
            // admin : admin
            this.m_repositoryUser.save(new User("admin",
                    "$2a$04$KNLUwOWHVQZVpXyMBNc7JOzbLiBjb9Tk9bP7KNcPI12ICuvzXQQKG", "ADMIN"));
        };
    }

}
