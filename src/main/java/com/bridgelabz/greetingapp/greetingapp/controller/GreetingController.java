package com.bridgelabz.greetingapp.greetingapp.controller;

import com.bridgelabz.greetingapp.greetingapp.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    @Autowired
    IGreetingService greetingService;

    @GetMapping("/home")
    public ResponseEntity<String> welcomeMessage() {
        return new ResponseEntity<>(greetingService.getFirstGreeting(), HttpStatus.OK);
    }

    @GetMapping("/home/helloworld")
    public ResponseEntity<String> helloWorld() {
        return new ResponseEntity<>(greetingService.getHelloMessage(), HttpStatus.OK);
    }
}
