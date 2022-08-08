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

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles", joinColumns = {
            @JoinColumn(name = "user_id") }, inverseJoinColumns = { @JoinColumn(name = "role_id") })
    private Set<Role> m_roles = new HashSet<>();

    public User()
    {
    }

    public User(String a_username, String a_password, Set<Role> a_roles)
    {
        super();
        this.m_username = a_username;
        this.m_password = a_password;
        this.m_roles = a_roles;
    }

    public User(String a_username, String a_password)
    {
        super();
        this.m_username = a_username;
        this.m_password = a_password;
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

    public Set<Role> getRoles()
    {
        return this.m_roles;
    }

    public void setRole(Set<Role> a_roles)
    {
        this.m_roles = a_roles;
    }
}