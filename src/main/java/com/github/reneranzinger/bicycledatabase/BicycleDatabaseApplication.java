package com.github.reneranzinger.bicycledatabase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.github.reneranzinger.bicycledatabase.persist.Role;
import com.github.reneranzinger.bicycledatabase.persist.RoleRepository;
import com.github.reneranzinger.bicycledatabase.persist.User;
import com.github.reneranzinger.bicycledatabase.persist.UserRepository;
import com.github.reneranzinger.bicycledatabase.service.UserService;

//https://www.youtube.com/watch?v=xEnvAAhMGu4
//https://www.youtube.com/watch?v=BnknNTN8icw
//https://www.youtube.com/watch?v=VVn9OG9nfH0&t=364s
// 42:20

@SpringBootApplication
public class BicycleDatabaseApplication
{
    private static final Logger logger = LoggerFactory.getLogger(BicycleDatabaseApplication.class);

    @Autowired
    private BicycleRepository m_repositoryBicycle;
    @Autowired
    private OwnerRepository m_repositoryOwner;
    @Autowired
    private BrandRepository m_repositoryBrand;
    @Autowired
    private UserRepository m_repositoryUser;
    @Autowired
    private RoleRepository m_repositoryRole;
    @Autowired
    private UserService m_userService;

    public static void main(String[] args)
    {
        logger.info("Starting BicycleDatabaseApplication::main");
        ConfigurableApplicationContext t_context = SpringApplication
                .run(BicycleDatabaseApplication.class, args);

        // print all registered bean names
        for (String t_name : t_context.getBeanDefinitionNames())
        {
            // System.out.println(t_name);
        }
        logger.info("Ending BicycleDatabaseApplication::main");
    }

    @Bean
    CommandLineRunner runner()
    {
        return args -> {
            logger.info("Starting CommandLineRunner");
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
                    "$2a$04$1.YhMIgNX/8TkCKGFUONWO1waedKhQ5KrnB30fl0Q01QKqmzLf.Zi"));
            // admin : admin
            this.m_repositoryUser.save(new User("admin",
                    "$2a$04$KNLUwOWHVQZVpXyMBNc7JOzbLiBjb9Tk9bP7KNcPI12ICuvzXQQKG"));

            this.m_repositoryRole.save(new Role(null, "ROLE_USER"));
            this.m_repositoryRole.save(new Role(null, "ROLE_MANAGER"));
            this.m_repositoryRole.save(new Role(null, "ROLE_ADMIN"));
            this.m_repositoryRole.save(new Role(null, "ROLE_SUPER_ADMIN"));

            this.m_userService.addRoleToUser("user", "ROLE_USER");
            this.m_userService.addRoleToUser("user", "ROLE_MANAGER");
            this.m_userService.addRoleToUser("admin", "ROLE_MANAGER");
            this.m_userService.addRoleToUser("admin", "ROLE_ADMIN");
            this.m_userService.addRoleToUser("admin", "ROLE_SUPER_ADMIN");

        };
    }

}
