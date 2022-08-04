package com.github.reneranzinger.bicycledatabase.auth.model;

import java.util.Collection;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.reneranzinger.bicycledatabase.persist.User;

public class UserDetailsImpl implements UserDetails
{
    private static final long serialVersionUID = 1L;

    private Long id;
    private String username;
    @JsonIgnore
    private String password;

    public UserDetailsImpl(Long id, String username, String password)
    {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public static UserDetailsImpl build(User user)
    {
        return new UserDetailsImpl(user.getId(), user.getUsername(), user.getPassword());
    }

    public Long getId()
    {
        return this.id;
    }

    @Override
    public String getPassword()
    {
        return this.password;
    }

    @Override
    public String getUsername()
    {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired()
    {
        return true;
    }

    @Override
    public boolean isAccountNonLocked()
    {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired()
    {
        return true;
    }

    @Override
    public boolean isEnabled()
    {
        return true;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || this.getClass() != o.getClass())
            return false;
        UserDetailsImpl user = (UserDetailsImpl) o;
        return Objects.equals(this.id, user.id);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        // TODO Auto-generated method stub
        return null;
    }
}