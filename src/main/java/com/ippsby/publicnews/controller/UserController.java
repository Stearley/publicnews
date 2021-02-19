package com.ippsby.publicnews.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.ippsby.publicnews.dto.SubscribePe;
import com.ippsby.publicnews.model.Pe;
import com.ippsby.publicnews.model.Security;
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
    public ResponseEntity<UserModel> addNewUser(@RequestBody UserModel userModel) {
        UserModel q = new UserModel();
        if (q.getRoleId() >= 1 && q.getRoleId() < 6 ) {
            UserModel s = userService.save(userModel);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else return  new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody UserModel userModel, HttpServletRequest request) {
        UserModel d = new UserModel();
        if (d.getRoleId() > 5 && d.getRoleId() < 1) {
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        else if (Long.parseLong(request.getHeader("Checker")) > (d.getRoleId()) ||
                Long.parseLong(request.getHeader("Checker")) == (d.getRoleId()) &&
                        Long.parseLong(request.getHeader("UserId"))==(d.getId())) {
            return new ResponseEntity<>(userService.save(userModel), HttpStatus.OK);

        }
         else return  new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

      @DeleteMapping("/{user}")
      public ResponseEntity<?> deleteUser(@PathVariable UserModel user, HttpServletRequest request) {
        UserModel z = new UserModel();
        if (Long.parseLong(request.getHeader("UserId"))==(z.getId())){
            userService.delete(user);
            return ResponseEntity.ok().build();
        }
        else if (Long.parseLong(request.getHeader("Checker")) > (z.getRoleId())){
              userService.delete(user);
              return ResponseEntity.ok().build();
          }
        else return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
      }

//    @DeleteMapping("/{user}")
//    public ResponseEntity<?> deleteUser(@PathVariable UserModel user, HttpServletRequest request) {
//        if (Integer.parseInt(request.getHeader("roleId")) > 4) {
//            userService.delete(user);
//            return ResponseEntity.ok().build();
//        }
//        else return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
//    }


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





