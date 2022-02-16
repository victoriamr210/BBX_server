package com.bbx.shop.assigment.dto;

import com.bbx.shop.assigment.model.enums.UserRoleEnum;

import java.io.Serializable;
import java.util.List;

public class UserDTO implements Serializable {

    private final static Long serialVersionID = 1L;
    private Long idUser;
    private String name;
    private String username;
    private String password;
    private List<UserRoleEnum> roles;

    public UserDTO() {
    }

    public UserDTO(Long idUser, String name, String username, List<UserRoleEnum> roles) {
        this.idUser = idUser;
        this.name = name;
        this.username = username;
        this.roles = roles;
    }

    public UserDTO(String name, String username, String email) {
        this.name = name;
        this.username = username;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public List<UserRoleEnum> getRoles() {
        return roles;
    }

    public void setRoles(List<UserRoleEnum> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("UserDTO{");
        sb.append("idUser=").append(idUser);
        sb.append(", name='").append(name).append('\'');
        sb.append(", username='").append(username).append('\'');
        sb.append(", roles=").append(roles);
        sb.append('}');
        return sb.toString();
    }
}
