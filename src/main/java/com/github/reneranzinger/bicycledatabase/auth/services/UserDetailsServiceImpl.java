package com.github.reneranzinger.bicycledatabase.auth.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.reneranzinger.bicycledatabase.auth.model.UserDetailsImpl;
import com.github.reneranzinger.bicycledatabase.persist.User;
import com.github.reneranzinger.bicycledatabase.persist.UserRepository;

//TODO have user service implement UserDetailsService as well
@Service
public class UserDetailsServiceImpl implements UserDetailsService
{
    private static final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        logger.info("UserDetailsServiceImpl::loadUserByUsername");
        User user = this.userRepository.findByUsername(username);
        if (user == null)
        {
            logger.info("User not found with username: " + username);
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        // TODO validation
        // .orElseThrow(
        // () -> new UsernameNotFoundException("User not found with username: "
        // + username));
        return UserDetailsImpl.build(user);
    }

}
