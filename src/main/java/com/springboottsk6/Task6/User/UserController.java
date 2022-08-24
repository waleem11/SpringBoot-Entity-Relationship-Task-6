package com.springboottsk6.Task6.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/authenticate")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping
    public String authenticationPage(@RequestBody User user){
        if(userService.verifyUser(user)){
            UserDetails uuser = new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                    new ArrayList<>());
            String accessToken = jwtUtil.generateToken(uuser);
            return accessToken;
        }
        else{
            return "Wrong Credentials";
        }
    }
}
