package com.bbx.shop.assigment.service;

import com.bbx.shop.assigment.dto.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> listUsers();

    UserDTO getUser(String username) throws Exception;

    UserDTO createUser(UserDTO userDTO) throws Exception;

    void deleteUser(Long idUser) throws Exception;
}
