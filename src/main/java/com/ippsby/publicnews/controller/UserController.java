package com.ippsby.publicnews.controller;

import com.ippsby.publicnews.model.UserModel;
import com.ippsby.publicnews.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;


    @PostMapping(path="/add")
    public @ResponseBody
    String addNewUser (@RequestParam String username
            , @RequestParam String password) {


        UserModel user = new UserModel();
        user.setUsername(username);
        user.setPassword(password);
        userRepository.save(user);
        return "Saved";
    }

}




