package com.github.reneranzinger.bicycledatabase.persist;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "bicycle", uniqueConstraints = @UniqueConstraint(columnNames = { "brand", "model" }))
public class Bicycle
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bicycle_id", nullable = false)
    private Long m_id;
    @Column(name = "brand", nullable = false, length = 512)
    private String m_brand;
    @Column(name = "model", nullable = false, length = 128)
    private String m_model;
    @Column(name = "color", nullable = false, length = 64)
    private String m_color;
    @Column(name = "register_number", nullable = false, length = 32)
    private String m_registerNumber;
    @Column(name = "year", nullable = false)
    private Integer m_year;
    @Column(name = "price", nullable = false)
    private Double m_price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", nullable = false)
    private Owner m_owner;

    public Bicycle()
    {
    }

    public Bicycle(String a_brand, String a_model, String a_color, String a_registerNumber,
            Integer a_year, Double a_price, Owner a_owner)
    {
        super();
        this.m_brand = a_brand;
        this.m_model = a_model;
        this.m_color = a_color;
        this.m_registerNumber = a_registerNumber;
        this.m_year = a_year;
        this.m_price = a_price;
        this.m_owner = a_owner;
    }

    public String getBrand()
    {
        return this.m_brand;
    }

    public void setBrand(String a_brand)
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

    public Double getPrice()
    {
        return this.m_price;
    }

    public void setPrice(Double a_price)
    {
        this.m_price = a_price;
    }

    public Long getId()
    {
        return this.m_id;
    }

    public void setId(Long a_id)
    {
        this.m_id = a_id;
    }

    public Owner getOwner()
    {
        return this.m_owner;
    }

    public void setOwner(Owner a_owner)
    {
        this.m_owner = a_owner;
    }

}
