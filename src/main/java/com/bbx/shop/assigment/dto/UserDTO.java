package com.bbx.shop.assigment.dto;

import java.io.Serializable;

public class UserDTO implements Serializable {

    private final static Long serialVersionID = 1L;
    private Long idUser;
    private String name;
    private String username;

    public UserDTO() {
    }

    public UserDTO(Long idUser, String name, String username) {
        this.idUser = idUser;
        this.name = name;
        this.username = username;
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


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("UserDTO{");
        sb.append("idUser=").append(idUser);
        sb.append(", name='").append(name).append('\'');
        sb.append(", username='").append(username).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
