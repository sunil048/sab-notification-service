package com.sabtok.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notification")
public class MessagePublishController {

    @PostMapping("/send")
    public String postMessage(@RequestBody String message) {
        System.out.println(message);
        return message;
    }
}
