package com.bbx.shop.assigment.auth.token;

import com.bbx.shop.assigment.dto.UserDTO;
import com.bbx.shop.assigment.model.enums.UserRoleEnum;

import java.io.Serializable;
import java.util.List;

public class JwtTokenResponse implements Serializable {

    private static final long serialVersionUID = 8317676219297719109L;

    private final String token;
    private final List<UserRoleEnum> roles;

    public JwtTokenResponse(String token,  List<UserRoleEnum> roles) {
        this.token = token;
        this.roles = roles;
    }

    public String getToken() {
        return this.token;
    }

    public List<UserRoleEnum> getRoles() {
        return roles;
    }
}

