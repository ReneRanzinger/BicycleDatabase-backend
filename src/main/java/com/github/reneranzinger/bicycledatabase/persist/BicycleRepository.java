package com.github.reneranzinger.bicycledatabase.persist;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface BicycleRepository extends CrudRepository<Bicycle, Long>
{
    @Query("select c from Bicycle c where c.m_model = ?1 order by c.m_year")
    List<Bicycle> findByModel(@Param("model") String a_model);
}
