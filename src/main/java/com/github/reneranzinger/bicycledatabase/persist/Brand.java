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
@Table(name = "brand", uniqueConstraints = @UniqueConstraint(columnNames = { "name" }))
public class Brand
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "brand_id", nullable = false)
    private Long m_id;

    @Column(name = "name", nullable = false, length = 64)
    private String m_name;

    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "m_brand")
    private List<Bicycle> m_bicycle;

    public Brand()
    {
    }

    public Brand(String a_name)
    {
        super();
        this.m_name = a_name;
    }

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

    public List<Bicycle> getBicycle()
    {
        return this.m_bicycle;
    }

    public void setBicycle(List<Bicycle> a_bicycle)
    {
        this.m_bicycle = a_bicycle;
    }

}
