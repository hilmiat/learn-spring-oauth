package com.example.oauthdemo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api")
public class DemoController {
    @GetMapping("/demo1")
    public String demo(){
        return "Hello from rest API";
    }

    @GetMapping("/me")
    public Principal getMe(Principal p){
        return p;
    }

}
