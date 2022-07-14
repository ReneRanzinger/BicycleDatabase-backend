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
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "owner", uniqueConstraints = @UniqueConstraint(columnNames = { "firstname",
        "lastname" }))
public class Owner
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "owner_id", nullable = false)
    private Long m_id;

    @Column(name = "firstname", nullable = false, length = 32)
    private String m_firstname;

    @Column(name = "lastname", nullable = false, length = 32)
    private String m_lastname;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "m_owners")
    private Set<Bicycle> m_bicycles = new HashSet<Bicycle>();

    public Owner()
    {
    }

    public Owner(String a_firstname, String a_lastname)
    {
        super();
        this.m_firstname = a_firstname;
        this.m_lastname = a_lastname;
    }

    public long getOwnerid()
    {
        return this.m_id;
    }

    public void setOwnerid(long a_id)
    {
        this.m_id = a_id;
    }

    public String getFirstname()
    {
        return this.m_firstname;
    }

    public void setFirstname(String a_firstname)
    {
        this.m_firstname = a_firstname;
    }

    public String getLastname()
    {
        return this.m_lastname;
    }

    public void setLastname(String a_lastname)
    {
        this.m_lastname = a_lastname;
    }

    public Set<Bicycle> getBicycle()
    {
        return this.m_bicycles;
    }

    public void setBicycle(Set<Bicycle> a_bicycles)
    {
        this.m_bicycles = a_bicycles;
    }

}
