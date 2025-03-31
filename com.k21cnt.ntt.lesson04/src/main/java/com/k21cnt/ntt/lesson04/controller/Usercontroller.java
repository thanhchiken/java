package com.k21cnt.ntt.lesson04.controller;

import com.k21cnt.ntt.lesson04.dto.UserDTO;
import com.k21cnt.ntt.lesson04.entity.User;
import com.k21cnt.ntt.lesson04.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@AllArgsConstructor
@NoArgsConstructor
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user-list")
    public List<User> findAll(){
        return userService.getUsersList();
    }

    @PostMapping("/user-add")
    public ResponseEntity<String> addUser( @Valid @RequestBody UserDTO userDTO){

        userService.create(userDTO);
        return ResponseEntity.badRequest().body("Users createdsuccessfully");
    }
}
