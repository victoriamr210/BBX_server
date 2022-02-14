package com.bbx.shop.assigment.service.impl;

import com.bbx.shop.assigment.dto.UserDTO;
import com.bbx.shop.assigment.mapper.UserMapper;
import com.bbx.shop.assigment.model.User;
import com.bbx.shop.assigment.repository.UserRepository;
import com.bbx.shop.assigment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.OptionalInt;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO getUser(Long idUser) throws Exception {
        if(idUser == null){
            throw new Exception("The user ID cannot be null");
        }

        Optional<User> userOptional = userRepository.findById(idUser);
        if(!userOptional.isPresent()){
            throw new Exception("The user with ID: " + idUser + "does not exist");
        }
        return UserMapper.pojo2DTO(userOptional.get());
    }
}
