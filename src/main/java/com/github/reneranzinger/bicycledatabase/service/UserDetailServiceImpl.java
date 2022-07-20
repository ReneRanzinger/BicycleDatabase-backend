package com.github.reneranzinger.bicycledatabase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.github.reneranzinger.bicycledatabase.persist.User;
import com.github.reneranzinger.bicycledatabase.persist.UserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService
{
    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String a_username) throws UsernameNotFoundException
    {
        User currentUser = this.repository.findByUsername(a_username);
        UserDetails user = new org.springframework.security.core.userdetails.User(a_username,
                currentUser.getPassword(), true, true, true, true,
                AuthorityUtils.createAuthorityList(currentUser.getRole()));
        return user;
    }

}