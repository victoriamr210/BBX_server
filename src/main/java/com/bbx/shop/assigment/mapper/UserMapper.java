package com.bbx.shop.assigment.mapper;

import com.bbx.shop.assigment.dto.UserDTO;
import com.bbx.shop.assigment.model.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {
    public static UserDTO pojo2DTO(User user){
        if(user == null){
            return null;
        }
        return new UserDTO(user.getIdUser(), user.getName(), user.getUsername(), user.getRoles());
    }

    public static List<UserDTO> pojo2DTO(List<User> userList){
        return userList.stream().map(user -> pojo2DTO(user)).collect(Collectors.toList());
    }
}
