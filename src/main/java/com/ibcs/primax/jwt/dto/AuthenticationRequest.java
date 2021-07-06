package com.ibcs.primax.jwt.dto;

import lombok.NoArgsConstructor;

/**
 * @author tuhin
 * @created_on 7/5/21 at 11:28 PM
 * @project primax
 **/

@NoArgsConstructor
public class AuthenticationRequest {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
