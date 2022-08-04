package com.github.reneranzinger.bicycledatabase.dto.response;

public class JwtResponse
{
    private String m_token;
    private String m_type = "Bearer";
    private Long m_id;
    private String m_username;
    private String m_email;

    public JwtResponse(String a_accessToken, Long a_id, String a_username, String a_email)
    {
        this.m_token = a_accessToken;
        this.m_id = a_id;
        this.m_username = a_username;
        this.m_email = a_email;
    }

    public String getAccessToken()
    {
        return this.m_token;
    }

    public void setAccessToken(String a_accessToken)
    {
        this.m_token = a_accessToken;
    }

    public String getTokenType()
    {
        return this.m_type;
    }

    public void setTokenType(String a_tokenType)
    {
        this.m_type = a_tokenType;
    }

    public Long getId()
    {
        return this.m_id;
    }

    public void setId(Long a_id)
    {
        this.m_id = a_id;
    }

    public String getEmail()
    {
        return this.m_email;
    }

    public void setEmail(String a_email)
    {
        this.m_email = a_email;
    }

    public String getUsername()
    {
        return this.m_username;
    }

    public void setUsername(String a_username)
    {
        this.m_username = a_username;
    }

}
