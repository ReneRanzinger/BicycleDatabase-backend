package com.github.reneranzinger.bicycledatabase.persist;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface BicycleRepository extends CrudRepository<Bicycle, Long>
{
    @Query("select c from Bicycle c where c.m_model = ?1 order by c.m_year")
    List<Bicycle> findByModel(String a_model);
}
