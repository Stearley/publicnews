package com.ippsby.publicnews.controller;

import com.ippsby.publicnews.repository.UserRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    final UserRepository userRepository;
    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;

    }

}
