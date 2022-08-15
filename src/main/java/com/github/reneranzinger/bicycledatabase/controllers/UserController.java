package com.github.reneranzinger.bicycledatabase.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.github.reneranzinger.bicycledatabase.persist.Role;
import com.github.reneranzinger.bicycledatabase.persist.User;
import com.github.reneranzinger.bicycledatabase.service.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserController
{
    @Autowired
    private UserService m_userService;

    @GetMapping("/list")
    public ResponseEntity<Iterable<User>> getUsers()
    {
        return ResponseEntity.ok(this.m_userService.getUsers());
    }

    @PostMapping("add")
    public ResponseEntity<User> saveUser(@RequestBody User a_user)
    {

        URI t_uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/user/add").toUriString());
        return ResponseEntity.created(t_uri).body(this.m_userService.saveUser(a_user));
    }

    @PostMapping("/role/add")
    public ResponseEntity<Role> saveRole(@RequestBody Role a_role)
    {
        URI t_uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/user/role/add").toUriString());
        return ResponseEntity.created(t_uri).body(this.m_userService.saveRole(a_role));
    }

}
