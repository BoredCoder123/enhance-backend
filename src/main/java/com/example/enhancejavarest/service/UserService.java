package com.example.enhancejavarest.service;

import com.example.enhancejavarest.entity.User;
import com.example.enhancejavarest.repository.UserRepository;
import com.example.enhancejavarest.request.UserLoginRequest;
import com.example.enhancejavarest.request.UserRegisterRequest;
import com.example.enhancejavarest.response.UserLoginResponse;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public String createUser(UserRegisterRequest userRegisterRequest) throws Exception {
        User existingUser = userRepository.getByEmail(userRegisterRequest.getEmail());
        if(existingUser!=null){
            throw new Exception("Unable to create user");
        }
        User newUser = new User();
        newUser.setName(userRegisterRequest.getName());
        newUser.setEmail(userRegisterRequest.getEmail());
        newUser.setPassword(userRegisterRequest.getPassword());
        newUser.setCoinsBalance(0);
        userRepository.save(newUser);
        return "User created";
    }


    public UserLoginResponse login(UserLoginRequest userLoginRequest) throws Exception{
        User user = userRepository.getByEmail(userLoginRequest.getEmail());
        if(user==null){
            throw new Exception("Unable to find the email");
        }else{
            if(!user.getPassword().equals(userLoginRequest.getPassword())){
                throw new Exception("Password mismatch");
            }
            return new UserLoginResponse("Successfully logged in");
        }
    }
}
