package com.bridgelabz.greetingapp.greetingapp.service;

import com.bridgelabz.greetingapp.greetingapp.model.GreetingMessage;
import com.bridgelabz.greetingapp.greetingapp.model.UserDetails;
import java.util.List;
import java.util.Optional;

public interface IGreetingService {
    GreetingMessage getFirstGreeting();
    GreetingMessage getHelloMessage();
    GreetingMessage getCustomGreeting(UserDetails userDetails);
    void saveGreetingInRepo(GreetingMessage greetMessage);
    Optional<GreetingMessage> findGreetingInRepo(long greetingId);
    List<GreetingMessage> getAllGreetings();
    void updateGreetingRepo(GreetingMessage greetMessage);
    void deleteGreetingFromRepo(long id);
}
