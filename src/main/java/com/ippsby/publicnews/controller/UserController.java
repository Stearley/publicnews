package com.ippsby.publicnews.controller;

import com.ippsby.publicnews.model.UserModel;
import com.ippsby.publicnews.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping(path="/add")
    @ResponseBody
    public String addNewUser () {



        return "Saved";
    }

}




