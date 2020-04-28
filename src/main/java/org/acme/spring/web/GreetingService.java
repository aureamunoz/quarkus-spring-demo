package org.acme.spring.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    private String message;

    public GreetingService(@Value("${greeting.message}") String message) {
        this.message = message;
    }

    public String greet(String name){
        return message+ " " + name;
    }
}
