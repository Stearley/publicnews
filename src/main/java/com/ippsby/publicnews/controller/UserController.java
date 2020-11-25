package com.ippsby.publicnews.controller;

import com.ippsby.publicnews.model.UserModel;
import com.ippsby.publicnews.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public List<UserModel> getAllUsers() {
        return userService.findAll();
    }

    @PostMapping("/create")
    public UserModel createUser(@Valid @RequestBody UserModel userModel)     {
        return userService.save(userModel);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<UserModel> addNewUser(@RequestBody UserModel userModel) {
        userModel.setRoleId(1);
        userService.save(userModel);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{userId}")
    public UserModel updateUser(@PathVariable(value = "userId") Long userId,
                                @Valid @RequestBody UserModel userData) {

        UserModel userModel = userService.findById(userId);

        userModel.setUsername(userData.getUsername());
        userModel.setPassword(userData.getPassword());
        userModel.setRoleId(userData.getRoleId());

        UserModel updatedUserData = userService.save(userModel);
       // return userService.save(userModel);
        return updatedUserData;
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable UserModel userId) {
        userService.delete(userId);
        return ResponseEntity.ok().build();
    }
}




