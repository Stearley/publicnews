package com.ippsby.publicnews.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.ippsby.publicnews.model.Security;
import com.ippsby.publicnews.model.Theme;
import com.ippsby.publicnews.model.UserModel;
import com.ippsby.publicnews.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
    public ResponseEntity<?> updateUser( @RequestBody UserModel userModel, HttpServletRequest request) {
        if (Integer.parseInt(request.getHeader("Test")) > 4) {
            return new ResponseEntity<>(userService.save(userModel), HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable UserModel userId, HttpServletRequest request) {
        if (Integer.parseInt(request.getHeader("Test")) > 4) {
            userService.delete(userId);
            return ResponseEntity.ok().build();
        }
        else return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @JsonView(Security.Local.class)
    @PostMapping("/login")
    public UserModel login(@RequestBody UserModel userModel){
        return userService.login(userModel.getUsername(), userModel.getPassword());
    }

    @GetMapping("/{userId}")
    public UserModel getUserById(@PathVariable UserModel userId) {
        return userId;
    }


}




