package com.example.hello_world.controller;

import com.example.hello_world.exception.BadRequestException;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api")
public class HelloWorldController {

    private static final Logger logger = LoggerFactory.getLogger(HelloWorldController.class);

    @GetMapping("/message")
    public String getGreeting() {
        logger.info("GET /api/message endpoint cagrildi.");
        return "Merhaba Dünya!";
    }

    @PostMapping("/message")
    public String postGreeting(@RequestBody(required = false) String name) {
        logger.info("POST /api/message endpoint cagrildi. Gonderilen isim: {}", name);

        if (name == null || name.trim().isEmpty()) {
            logger.error("Hatali istek: Isim bos.");
            throw new BadRequestException("Lütfen bir isim yazınız.");
        }
        if ("TÜRKSAT".equalsIgnoreCase(name)) {
            logger.info("TÜRKSAT ismi algilandi.");
            return "Merhaba TÜRKSAT!";
        } else {
            return "Merhaba " + name + "!";
        }
    }
}
