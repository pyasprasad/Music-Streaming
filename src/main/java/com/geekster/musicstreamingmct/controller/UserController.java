package com.geekster.musicstreamingmct.controller;


import com.geekster.musicstreamingmct.dto.SignInInput;
import com.geekster.musicstreamingmct.dto.SignInOutput;
import com.geekster.musicstreamingmct.dto.SignUpInput;
import com.geekster.musicstreamingmct.dto.SignUpOutput;
import com.geekster.musicstreamingmct.service.TokenService;
import com.geekster.musicstreamingmct.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    TokenService authService;

    @PostMapping("/signup")
    public SignUpOutput signUp(@RequestBody SignUpInput signUpDto){
        return userService.signUp(signUpDto);
    }

    @PostMapping("/signin")
    public SignInOutput signIn(@RequestBody SignInInput signInDto){

        return userService.signIn(signInDto);
    }

    @DeleteMapping("/signout")
    public ResponseEntity<String> signOut(@RequestParam String email , @RequestParam String token){
        HttpStatus status;
        String msg=null;

        if(authService.authenticate(email,token))
        {
            authService.deleteToken(token);
            msg = "Signout Successful";
            status = HttpStatus.OK;

        }
        else
        {
            msg = "Invalid User";
            status = HttpStatus.FORBIDDEN;
        }

        return new ResponseEntity<String>(msg , status);
    }

}
