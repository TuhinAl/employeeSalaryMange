package com.ibcs.primax.jwt.dto;

import lombok.AllArgsConstructor;

/**
 * @author tuhin
 * @created_on 7/5/21 at 11:28 PM
 * @project primax
 **/

@AllArgsConstructor
public class AuthenticationResponse {

    private String jwtToken;

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
