package com.github.reneranzinger.bicycledatabase.dto.request;

public class LoginRequest
{
    private String m_username;
    private String m_password;

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
}
