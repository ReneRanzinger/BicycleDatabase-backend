package com.github.reneranzinger.bicycledatabase.persist;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long>
{
    @Query("select c from Role c where c.m_name = ?1")
    public Role findByName(String a_name);
}