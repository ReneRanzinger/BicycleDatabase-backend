package com.github.reneranzinger.bicycledatabase.auth.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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
    private Collection<? extends GrantedAuthority> m_authorities = new ArrayList<>();

    public UserDetailsImpl(Long id, String username, String password)
    {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public static UserDetailsImpl build(User user)
    {
        UserDetailsImpl t_userDetails = new UserDetailsImpl(user.getId(), user.getUsername(),
                user.getPassword());
        Collection<SimpleGrantedAuthority> t_authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            t_authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        t_userDetails.setAuthorities(t_authorities);
        return t_userDetails;
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
        return this.m_authorities;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> a_authorities)
    {
        this.m_authorities = a_authorities;
    }
}
