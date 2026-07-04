package com.embarkX.url_shortener.controllers;

import com.embarkX.url_shortener.dtos.LoginRequest;
import com.embarkX.url_shortener.dtos.RegisterRequest;
import com.embarkX.url_shortener.models.User;
import com.embarkX.url_shortener.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.boot.webmvc.autoconfigure.WebMvcProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {
private UserService userService;
    @PostMapping("/public/register")
    public ResponseEntity<?> registerUser(@RequestBody RegisterRequest registerRequest){
        User user=new User();
        user.setUsername(registerRequest.getUsername());
        user.setPassword(registerRequest.getPassword());
        user.setRole("ROLE_USER");
        user.setEmail(registerRequest.getEmail());

        userService.registerUser(user);
        return ResponseEntity.ok("User Registered Successfully");
    }

    @PostMapping("/public/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest){
        System.out.println(loginRequest.getUsername());
    return ResponseEntity.ok(userService.loginUser(loginRequest));
    }
}
