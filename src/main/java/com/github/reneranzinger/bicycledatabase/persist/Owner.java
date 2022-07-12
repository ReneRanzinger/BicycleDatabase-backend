package com.github.reneranzinger.bicycledatabase.persist;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "m_owner")
    private List<Bicycle> m_bicycle;

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

    public List<Bicycle> getBicycle()
    {
        return this.m_bicycle;
    }

    public void setBicycle(List<Bicycle> a_bicycle)
    {
        this.m_bicycle = a_bicycle;
    }

}
