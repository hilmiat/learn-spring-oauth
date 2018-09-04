package com.ebdesk.controller;

import java.security.Principal;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class UserController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<String> endPoint() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("You Shall Not Pass!");
    }
	
	@RequestMapping(value = "/me", method = RequestMethod.GET)
    public Principal getMe(Principal p) {
        return p;
    }
}
