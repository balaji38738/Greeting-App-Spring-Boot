package com.bridgelabz.greetingapp.greetingapp.service;

import com.bridgelabz.greetingapp.greetingapp.model.GreetingMessage;
import com.bridgelabz.greetingapp.greetingapp.model.UserDetails;
import com.bridgelabz.greetingapp.greetingapp.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GreetingService implements IGreetingService{
    @Autowired
    GreetingMessage greetingMessage;

    @Autowired
    GreetingRepository greetingRepository;

    public GreetingMessage getFirstGreeting() {
        greetingMessage.setMessage("Greetings app home");
        greetingMessage.setId(greetingRepository.count() + 1);
        greetingRepository.save(greetingMessage);
        return greetingMessage;
    }

    public GreetingMessage getHelloMessage() {
        greetingMessage.setMessage("Hello, world!");
        greetingMessage.setId(greetingRepository.count() + 1);
        greetingRepository.save(greetingMessage);
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
        greetingMessage.setId(greetingRepository.count() + 1);
        greetingRepository.save(greetingMessage);
        return greetingMessage;
    }

    public void saveGreetingInRepo(GreetingMessage greetMessage) {
        greetMessage.setId(greetingRepository.count() + 1);
        greetingRepository.save(greetMessage);
    }

    @Override
    public Optional<GreetingMessage> findGreetingInRepo(long greetingId) {
        return greetingRepository.findById(greetingId);
    }
}
