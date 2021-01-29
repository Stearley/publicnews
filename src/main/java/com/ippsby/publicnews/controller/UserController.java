package com.ippsby.publicnews.controller;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.ippsby.publicnews.dto.SubscribePe;
import com.ippsby.publicnews.model.Pe;
import com.ippsby.publicnews.model.Security;
import com.ippsby.publicnews.model.UserModel;
import com.ippsby.publicnews.service.UserService;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Set;

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
    public ResponseEntity<UserModel> addNewUser(@RequestBody UserModel userModel) {
        UserModel s = userService.save(userModel);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//
//    @PutMapping
//    public ResponseEntity<?> updateUser( @RequestBody UserModel userModel, HttpServletRequest request) {
//        if (Integer.parseInt(request.getHeader("roleId=")) > 4) {
//            return new ResponseEntity<>(userService.save(userModel), HttpStatus.OK);
//        } else return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
//    }
    @PutMapping
    public ResponseEntity<?> updateUser (@RequestBody UserModel userModel,HttpServletRequest request){
        UserModel d;
            d = userService.getByRoleId(userModel.getRoleId());
        if (Integer.parseInt(request.getHeader("Checker")) == d){
            UserModel s = userService.save(userModel);
            return new ResponseEntity<>(HttpStatus.OK);

        }
        else return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @DeleteMapping("/{Id}")
    public ResponseEntity<?> deleteUser(@PathVariable UserModel Id, HttpServletRequest request) {
        if (Integer.parseInt(request.getHeader("roleId")) > 4) {
            userService.delete(Id);
            return ResponseEntity.ok().build();
        }
        else return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @JsonView(Security.Local.class)
    @PostMapping("/login")
    public UserModel login(@RequestBody UserModel userModel){
        return userService.login(userModel.getUsername(), userModel.getPassword());
    }

    @GetMapping("/{Id}")
    public UserModel getUserById(@PathVariable UserModel Id) {
        return Id;
    }


    @PostMapping("/sub")
    public ResponseEntity subscribe (@RequestBody SubscribePe subscribePe){
        Pe pe = new Pe();
        pe.setPeId(subscribePe.getPeId());
        UserModel userModel = userService.find(subscribePe.getId());
        userModel.addPe(pe);
        userService.save(userModel);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}





