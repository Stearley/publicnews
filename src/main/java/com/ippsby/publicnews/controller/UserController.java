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
    public @ResponseBody
    String addNewUser (@RequestParam String username
            , @RequestParam String password) {


        UserModel user = new UserModel();
        user.setUsername(username);
        user.setPassword(password);
        userService.save(user);
        return "Saved";
    }

}




