package com.bridgelabz.greetingapp.greetingapp.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingService implements IGreetingService{
    public String getFirstGreeting() {
        return "Greetings app home";
    }
}
