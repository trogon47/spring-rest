package com.markdemo.service;

import org.springframework.stereotype.Service;

@Service
public class WelcomeService {
    public String retrieveWelcomeMessage() {
        return "This is great! I see something on screen!";
    }
}
