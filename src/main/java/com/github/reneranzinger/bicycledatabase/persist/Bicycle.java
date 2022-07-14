package com.github.reneranzinger.bicycledatabase.persist;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "bicycle", uniqueConstraints = @UniqueConstraint(columnNames = { "brand_id",
        "model" }))
public class Bicycle
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bicycle_id", nullable = false)
    private Long m_id;

    @Column(name = "model", nullable = false, length = 128)
    private String m_model;

    @Column(name = "color", nullable = false, length = 64)
    private String m_color;

    @Column(name = "register_number", nullable = false, length = 32)
    private String m_registerNumber;

    @Column(name = "year", nullable = false)
    private Integer m_year;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "bicycle_owner", joinColumns = {
            @JoinColumn(name = "bicycle_id") }, inverseJoinColumns = {
                    @JoinColumn(name = "owner_id") })
    private Set<Owner> m_owners = new HashSet<Owner>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand m_brand;

    public Bicycle()
    {
    }

    public Bicycle(Brand a_brand, String a_model, String a_color, String a_registerNumber,
            Integer a_year)
    {
        super();
        this.m_brand = a_brand;
        this.m_model = a_model;
        this.m_color = a_color;
        this.m_registerNumber = a_registerNumber;
        this.m_year = a_year;
    }

    public Brand getBrand()
    {
        return this.m_brand;
    }

    public void setBrand(Brand a_brand)
    {
        this.m_brand = a_brand;
    }

    public String getModel()
    {
        return this.m_model;
    }

    public void setModel(String a_model)
    {
        this.m_model = a_model;
    }

    public String getColor()
    {
        return this.m_color;
    }

    public void setColor(String a_color)
    {
        this.m_color = a_color;
    }

    public String getRegisterNumber()
    {
        return this.m_registerNumber;
    }

    public void setRegisterNumber(String a_registerNumber)
    {
        this.m_registerNumber = a_registerNumber;
    }

    public Integer getYear()
    {
        return this.m_year;
    }

    public void setYear(Integer a_year)
    {
        this.m_year = a_year;
    }

    public Long getId()
    {
        return this.m_id;
    }

    public void setId(Long a_id)
    {
        this.m_id = a_id;
    }

    public Set<Owner> getOwners()
    {
        return this.m_owners;
    }

    public void setOwners(Set<Owner> a_owners)
    {
        this.m_owners = a_owners;
    }

}
