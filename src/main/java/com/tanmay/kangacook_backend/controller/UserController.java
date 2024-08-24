package com.tanmay.kangacook_backend.controller;

import com.tanmay.kangacook_backend.model.User;
import com.tanmay.kangacook_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kangacook")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody User user) {
        userService.saveNewUser(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        User userDB = userService.loginUser(user);
        if(userDB !=null) {
            return new ResponseEntity<>("Login Successful", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Login Failed", HttpStatus.BAD_REQUEST);
        }
    }
}
