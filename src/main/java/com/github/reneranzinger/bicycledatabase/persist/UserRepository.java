package com.github.reneranzinger.bicycledatabase.persist;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long>
{
    @Query("select c from User c where c.m_username = ?1")
    public User findByUsername(String a_username);
}