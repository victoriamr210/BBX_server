package com.bbx.shop.assigment.service;

import com.bbx.shop.assigment.dto.UserDTO;

public interface UserService {
    UserDTO getUser(Long idUser) throws Exception;
}
