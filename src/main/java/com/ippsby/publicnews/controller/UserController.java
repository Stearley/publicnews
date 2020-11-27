package com.ippsby.publicnews.controller;

import com.ippsby.publicnews.model.UserModel;
import com.ippsby.publicnews.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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

    @PostMapping
    @ResponseBody
    public ResponseEntity<UserModel> addNewUser(@RequestBody UserModel userModel, HttpServletRequest request) {
        if(Integer.parseInt(request.getHeader("Test")) > 1){
            userModel.setRoleId(1L);
           UserModel s = userService.save(userModel);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @PutMapping
    public UserModel updateUser(@PathVariable(value = "userId") Long userId,
                                @Valid @RequestBody UserModel userData) {

        UserModel userModel = userService.findById(userId);

        userModel.setUsername(userData.getUsername());
        userModel.setPassword(userData.getPassword());
        userModel.setRoleId(userData.getRoleId());

        return userService.save(userModel);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable UserModel userId) {
        userService.delete(userId);
        return ResponseEntity.ok().build();
    }


    @PostMapping("/login")
    public UserModel login(@RequestBody UserModel userModel){
        return userService.login(userModel.getUsername(), userModel.getPassword());
    }


}




