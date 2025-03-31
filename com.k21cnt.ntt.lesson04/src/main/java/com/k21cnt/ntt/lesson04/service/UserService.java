package com.k21cnt.ntt.lesson04.service;

import com.k21cnt.ntt.lesson04.entity.User;
import com.k21cnt.ntt.lesson04.dto.UserDTO;
import com.k21cnt.ntt.lesson04.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    private final List<User> usersList = new ArrayList<>();
    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
        usersList.add(User.builder()
                .id(1L)
                .username("nguyenvan")
                .password("Abcd1234")
                .fullname("Nguyen Van A")
                .email("nguyen@example.com")
                .phone("+84912345678")
                .age(25)
                .status(true)
                .build());
    }

    public List<User> getUsersList() {
        return usersList;
    }

    public Boolean create(UserDTO userDTO) {
        try {
            if (userDTO == null) {
                logger.warn("UserDTO is null, cannot create user");
                return false;
            }

            User user = userMapper.toUser(userDTO);
            user.setId(usersList.size() + 1L);
            return usersList.add(user);
        } catch (Exception e) {
            logger.error("Error creating user: {}", userDTO, e);
            return false;
        }
    }
}