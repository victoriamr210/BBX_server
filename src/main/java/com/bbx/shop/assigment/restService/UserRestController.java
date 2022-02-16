package com.bbx.shop.assigment.restService;

import com.bbx.shop.assigment.dto.UserDTO;
import com.bbx.shop.assigment.mapper.UserMapper;
import com.bbx.shop.assigment.repository.UserRepository;
import com.bbx.shop.assigment.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

    private final Logger log = LoggerFactory.getLogger(UserRestController.class);

    @Autowired
    private UserService userService;

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Secured("ROLE_ADMIN")
    @GetMapping("/list")
    List<UserDTO> listUsers(){
        return userService.listUsers();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/addUser")
    ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO){
        log.info("Add user: " + userDTO.getName());
        try{
            UserDTO user = userService.createUser(userDTO);
            return ResponseEntity.ok(user);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/delete/{idUser}")
    ResponseEntity<HttpStatus> deleteUser(@PathVariable Long idUser){
        log.info("Delete User: " + idUser);
        try{
            userService.deleteUser(idUser);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
