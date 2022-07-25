package com.github.reneranzinger.bicycledatabase;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.github.reneranzinger.bicycledatabase.persist.Brand;
import com.github.reneranzinger.bicycledatabase.persist.BrandRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class CarRepositoryTest
{
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private BrandRepository repository;

    @Test
    public void saveBrand()
    {
        Brand t_brand = new Brand("Tesla");
        this.entityManager.persistAndFlush(t_brand);

        assertThat(t_brand.getId()).isNotNull();
    }

    @Test
    public void deleteBrands()
    {
        this.entityManager.persistAndFlush(new Brand("Tesla"));
        this.entityManager.persistAndFlush(new Brand("Mini"));

        this.repository.deleteAll();
        assertThat(this.repository.findAll()).isEmpty();
    }

}
