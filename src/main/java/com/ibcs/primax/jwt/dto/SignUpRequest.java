package com.ibcs.primax.jwt.dto;

/**
 * @author tuhin
 * @created_on 7/5/21 at 11:22 PM
 * @project primax
 **/

public class SignUpRequest {

    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
