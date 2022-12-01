package com.example.dockerrelease.user.controller;

import com.example.dockerrelease.user.dao.UserRepository;
import com.example.dockerrelease.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("")
    public List<User> getUser() {

       return userRepository.findAll();
    }
}
