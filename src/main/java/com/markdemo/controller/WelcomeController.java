package com.markdemo.controller;

import com.markdemo.service.WelcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @Autowired
    private WelcomeService service;

    @GetMapping("welcome")
    String welcomeMessage() {
        return service.retrieveWelcomeMessage();
    }

}

