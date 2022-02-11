package com.bbx.shop.assigment.service;

import com.bbx.shop.assigment.dto.UserDTO;

public interface UserService {
    UserDTO findById(Long idUser) throws Exception;
}
