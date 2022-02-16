package com.bbx.shop.assigment.model;

import com.bbx.shop.assigment.model.enums.UserRoleEnum;
import org.springframework.context.annotation.Role;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.Collection;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long idUser;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;

    @ElementCollection(targetClass = UserRoleEnum.class, fetch = FetchType.EAGER)
    @JoinTable(name = "User_Roles", joinColumns = @JoinColumn(name = "userName"))
    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private List<UserRoleEnum> roles;

    public User() {
    }

    public User(String name, String username, String password, List<UserRoleEnum> roles) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.roles = roles;
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
        final StringBuffer sb = new StringBuffer("User{");
        sb.append("idUser=").append(idUser);
        sb.append(", name='").append(name).append('\'');
        sb.append(", username='").append(username).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", roles='").append(roles).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
