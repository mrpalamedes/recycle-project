package com.project.demo.controller;

import com.project.demo.dto.user.SignUpDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.demo.dto.ResponseDto;
import com.project.demo.dto.user.SignInDto;
import com.project.demo.dto.user.SignInResponseDto;
import com.project.demo.entity.User;
import com.project.demo.exception.AuthenticationFailException;
import com.project.demo.exception.CustomeException;
import com.project.demo.repository.UserRepository;
import com.project.demo.service.AuthenticationService;
import com.project.demo.service.UserService;

@RestController
@RequestMapping("user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
    
    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationService authenticationService;

    @Autowired
    UserService userService;

    @GetMapping("/all")
    public User findUser(@RequestParam("token") String token) throws AuthenticationFailException{
        authenticationService.authenticate(token);
        User user = authenticationService.getUser(token);
        user.getEmail();
        return userRepository.findUserByEmail(user.getEmail());
    }

    @PostMapping("/signup")
    public ResponseDto signUp(@RequestBody SignUpDto signUpDto) throws CustomeException{
        return userService.signUp(signUpDto);
    }

    @PostMapping("/signin")
    public SignInResponseDto signIn(@RequestBody SignInDto signInDto) throws CustomeException{
        return userService.signIn(signInDto);
    }

}
