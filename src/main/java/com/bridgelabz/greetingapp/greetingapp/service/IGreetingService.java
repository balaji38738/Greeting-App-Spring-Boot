package com.bridgelabz.greetingapp.greetingapp.service;

import com.bridgelabz.greetingapp.greetingapp.model.GreetingMessage;
import com.bridgelabz.greetingapp.greetingapp.model.UserDetails;

public interface IGreetingService {
    GreetingMessage getFirstGreeting();
    GreetingMessage getHelloMessage();
    GreetingMessage getCustomGreeting(UserDetails userDetails);
}
