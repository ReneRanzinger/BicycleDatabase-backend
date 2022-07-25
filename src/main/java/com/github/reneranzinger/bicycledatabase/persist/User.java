package com.github.reneranzinger.bicycledatabase.persist;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false, updatable = false)
    private Long m_id;

    @Column(name = "username", nullable = false, unique = true)
    private String m_username;

    @Column(name = "password", nullable = false)
    private String m_password;

    @Column(name = "role", nullable = false)
    private String m_role;

    public User()
    {
    }

    public User(String a_username, String a_password, String a_role)
    {
        super();
        this.m_username = a_username;
        this.m_password = a_password;
        this.m_role = a_role;
    }

    public Long getId()
    {
        return this.m_id;
    }

    public void setId(Long a_id)
    {
        this.m_id = a_id;
    }

    public String getUsername()
    {
        return this.m_username;
    }

    public void setUsername(String a_username)
    {
        this.m_username = a_username;
    }

    public String getPassword()
    {
        return this.m_password;
    }

    public void setPassword(String a_password)
    {
        this.m_password = a_password;
    }

    public String getRole()
    {
        return this.m_role;
    }

    public void setRole(String a_role)
    {
        this.m_role = a_role;
    }
}