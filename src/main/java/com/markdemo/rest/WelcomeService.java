package com.markdemo.rest;

import org.springframework.stereotype.Service;

@Service
class WelcomeService {
    public String retrieveWelcomeMessage() {
        return "This is great! I see something on screen!";
    }
}
