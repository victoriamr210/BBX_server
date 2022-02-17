package com.bbx.shop.assigment.service.impl;

import com.bbx.shop.assigment.dto.UserDTO;
import com.bbx.shop.assigment.mapper.UserMapper;
import com.bbx.shop.assigment.model.User;
import com.bbx.shop.assigment.model.enums.UserRoleEnum;
import com.bbx.shop.assigment.repository.UserRepository;
import com.bbx.shop.assigment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDTO> listUsers() {
        return UserMapper.pojo2DTO((List<User>) userRepository.findAll());
    }

    @Override
    public UserDTO getUser(String username) throws Exception {
        if(username == null){
            throw new Exception("The user ID cannot be null");
        }

        Optional<User> userOptional = userRepository.findByUsername(username);
        if(!userOptional.isPresent()){
            throw new Exception("The user with username : " + username + "does not exist");
        }
        return UserMapper.pojo2DTO(userOptional.get());
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) throws Exception {
        if(userDTO == null){
            throw new Exception("The userDTO cannot be null");
        }
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode(userDTO.getPassword());
        User user = new User(userDTO.getName(), userDTO.getUsername(), password, userDTO.getRoles());
        userRepository.save(user);
        return UserMapper.pojo2DTO(user);

    }

    @Override
    public void deleteUser(Long idUser) throws Exception {
        if(idUser == null){
            throw new Exception("The User ID cannot be null");
        }

        Optional<User> userOptional = userRepository.findById(idUser);
        if(!userOptional.isPresent()){
            throw new Exception("The user with ID: " + idUser + " does not exist");
        }
        userRepository.delete(userOptional.get());
    }
}
