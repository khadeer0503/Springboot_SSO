package com.example.Springboot_SSO.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

    @GetMapping(value = "/")
    @ResponseBody
    public String dashboard() {
        return "Welcome to the Dashboard page!";
    }


    @GetMapping("/loginPage")
    public String login() {
        return "login";
    }

    @GetMapping("/home")
    //@ResponseBody
    public String home() {
        return "home";
    }

    @GetMapping("/welcome")
    @ResponseBody
    public String getProfile(){
        return "Welcome - To Home Page";
    }
  
    @GetMapping("/secure")
    @ResponseBody
    public String secure() {
        return "Welcome to the secure page!";
    }
    
}
