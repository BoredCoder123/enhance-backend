package com.example.enhancejavarest.controller;

import com.example.enhancejavarest.entity.User;
import com.example.enhancejavarest.request.UserLoginRequest;
import com.example.enhancejavarest.request.UserRegisterRequest;
import com.example.enhancejavarest.response.UserLoginResponse;
import com.example.enhancejavarest.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@Log4j2
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/test")
    public String heartbeat(){
        return "Test heartbeat. Current local time is: " + LocalDateTime.now().toString();
    }

    @PostMapping("/u/register")
    public ResponseEntity<String> registerUser(@RequestBody UserRegisterRequest userRegisterRequest){
        try{
            String returnedResponse = userService.createUser(userRegisterRequest);
            return new ResponseEntity<String>(returnedResponse, HttpStatus.OK);
        }catch(Exception e){
            log.error(e.toString());
            return new ResponseEntity<String>("Unable to create user", HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/u/login")
    public ResponseEntity loginUser(@RequestBody UserLoginRequest userLoginRequest){
        try{
            UserLoginResponse userLoginResponse = userService.login(userLoginRequest);
            return new ResponseEntity(userLoginResponse, HttpStatus.OK);
        }catch(Exception e){
            log.error(e.toString());
            return new ResponseEntity("Unable to login", HttpStatus.UNAUTHORIZED);
        }
    }
}
