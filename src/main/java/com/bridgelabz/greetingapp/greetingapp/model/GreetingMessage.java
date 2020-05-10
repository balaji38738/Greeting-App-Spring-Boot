package com.bridgelabz.greetingapp.greetingapp.model;

import org.springframework.stereotype.Component;

@Component
public class GreetingMessage {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
