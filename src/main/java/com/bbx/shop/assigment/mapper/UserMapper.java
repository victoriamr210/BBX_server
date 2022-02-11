package com.bbx.shop.assigment.mapper;

import com.bbx.shop.assigment.dto.UserDTO;
import com.bbx.shop.assigment.model.User;

public class UserMapper {
    public static UserDTO pojo2DTO(User user){
        return new UserDTO(user.getIdUser(), user.getName(), user.getUsername());
    }
}
