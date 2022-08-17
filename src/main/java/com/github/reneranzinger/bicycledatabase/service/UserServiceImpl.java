package com.github.reneranzinger.bicycledatabase.service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.reneranzinger.bicycledatabase.persist.Role;
import com.github.reneranzinger.bicycledatabase.persist.RoleRepository;
import com.github.reneranzinger.bicycledatabase.persist.User;
import com.github.reneranzinger.bicycledatabase.persist.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService
{
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository m_repoUser;
    @Autowired
    private RoleRepository m_repoRole;

    @Override
    public User saveUser(User a_user)
    {
        logger.info("Save new user: {}", a_user.getUsername());
        return this.m_repoUser.save(a_user);
    }

    @Override
    public Role saveRole(Role a_role)
    {
        logger.info("Save new role: {}", a_role.getName());
        return this.m_repoRole.save(a_role);
    }

    @Override
    public void addRoleToUser(String a_username, String a_roleName)
    {
        logger.info("Adding role {} to user {}", a_roleName, a_username);

        User t_user = this.m_repoUser.findByUsername(a_username);
        Role t_role = this.m_repoRole.findByName(a_roleName);
        // TODO: validation
        t_user.getRoles().add(t_role);
    }

    @Override
    public User getUser(String a_username)
    {
        logger.info("Retrieving user with name {}", a_username);
        return this.m_repoUser.findByUsername(a_username);
    }

    @Override
    public Iterable<User> getUsers()
    {
        logger.info("Fetching all user");
        return this.m_repoUser.findAll();
    }

}
