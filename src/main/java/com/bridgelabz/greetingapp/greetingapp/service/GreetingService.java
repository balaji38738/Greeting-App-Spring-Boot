package com.bridgelabz.greetingapp.greetingapp.service;

import com.bridgelabz.greetingapp.greetingapp.model.GreetingMessage;
import com.bridgelabz.greetingapp.greetingapp.model.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetingService implements IGreetingService{
    @Autowired
    GreetingMessage greetingMessage;

    public GreetingMessage getFirstGreeting() {
        greetingMessage.setMessage("Greetings app home");
        return greetingMessage;
    }

    public GreetingMessage getHelloMessage() {
        greetingMessage.setMessage("Hello, world!");
        return greetingMessage;
    }

    public GreetingMessage getCustomGreeting(UserDetails userDetails) {
        if (userDetails.getFirstName() != null && userDetails.getLastName() != null) {
            greetingMessage.setMessage("Hello, " + userDetails.getFirstName() +
                    " " + userDetails.getLastName() + "!");
        } else if (userDetails.getFirstName() != null) {
            greetingMessage.setMessage("Hello, " + userDetails.getFirstName() + "!");
        } else if (userDetails.getLastName() != null) {
            greetingMessage.setMessage("Hello, " + userDetails.getLastName() + "!");
        } else {
            return getHelloMessage();
        }
        return greetingMessage;
    }
}
