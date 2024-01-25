package com.example.SpringBootP3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogingController {


    @GetMapping("/login")
    public String loginPage(){

        return "auth-login-basic";
    }
    @GetMapping("/register")
    public String registerPage(){

        return "auth-register-basic";
    }
    @GetMapping("/forget_password")
    public String forgetPassPage(){

        return "auth-forgot-password-basic";
    }
}
