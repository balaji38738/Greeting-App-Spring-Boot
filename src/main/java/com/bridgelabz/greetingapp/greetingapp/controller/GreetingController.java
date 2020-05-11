package com.bridgelabz.greetingapp.greetingapp.controller;

import com.bridgelabz.greetingapp.greetingapp.model.GreetingMessage;
import com.bridgelabz.greetingapp.greetingapp.model.UserDetails;
import com.bridgelabz.greetingapp.greetingapp.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class GreetingController {
    @Autowired
    IGreetingService greetingService;

    @GetMapping("/home")
    public ResponseEntity<GreetingMessage> welcomeMessage() {
        return new ResponseEntity<>(greetingService.getFirstGreeting(), HttpStatus.OK);
    }

    @GetMapping("/home/hello-world")
    public ResponseEntity<GreetingMessage> helloWorld() {
        return new ResponseEntity<>(greetingService.getHelloMessage(), HttpStatus.OK);
    }

    @PostMapping("home/custom-greeting")
    public ResponseEntity<GreetingMessage> customGreeting(@RequestBody UserDetails userDetails) {
        return new ResponseEntity<>(greetingService.getCustomGreeting(userDetails), HttpStatus.OK);
    }

    @PostMapping("home/save-greeting")
    public void saveGreeting(@RequestBody GreetingMessage greetingMessage) {
        greetingService.saveGreetingInRepo(greetingMessage);
    }

    @GetMapping("home/find-greeting/{greetingId}")
    public ResponseEntity<Optional<GreetingMessage>> findGreeting(@PathVariable long greetingId) {
        return new ResponseEntity<>(greetingService.findGreetingInRepo(greetingId), HttpStatus.OK);
    }

    @GetMapping("home/find-greeting/all")
    public ResponseEntity<List<GreetingMessage>> allGreetings() {
        return new ResponseEntity<>(greetingService.getAllGreetings(), HttpStatus.OK);
    }

    @PostMapping("home/update-greeting")
    public void updateGreeting(@RequestBody GreetingMessage greetingMessage) {
        greetingService.updateGreetingRepo(greetingMessage);
    }
}
