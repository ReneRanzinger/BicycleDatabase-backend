package com.github.reneranzinger.bicycledatabase.persist;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id", nullable = false, updatable = false)
    private Long m_id;

    @Column(name = "name", nullable = false, unique = true)
    private String m_name;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "m_roles")
    private Set<User> m_users = new HashSet<User>();

    public Long getId()
    {
        return this.m_id;
    }

    public void setId(Long a_id)
    {
        this.m_id = a_id;
    }

    public String getName()
    {
        return this.m_name;
    }

    public void setName(String a_name)
    {
        this.m_name = a_name;
    }

    public Set<User> getUsers()
    {
        return this.m_users;
    }

    public void setUsers(Set<User> a_users)
    {
        this.m_users = a_users;
    }

}
