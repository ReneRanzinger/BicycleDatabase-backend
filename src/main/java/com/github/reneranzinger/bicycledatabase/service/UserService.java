package com.github.reneranzinger.bicycledatabase.service;

import com.github.reneranzinger.bicycledatabase.persist.Role;
import com.github.reneranzinger.bicycledatabase.persist.User;

public interface UserService
{
    public User saveUser(User a_user);

    public Role saveRole(Role a_role);

    public void addRoleToUser(String a_username, String a_roleName);

    public User getUser(String a_username);

    public Iterable<User> getUsers();
}
