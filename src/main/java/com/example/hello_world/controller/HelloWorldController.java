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
    public String postGreeting(
            @RequestParam(required = false) String name,
            @RequestBody(required = false) String bodyName) {

        if (bodyName != null && !bodyName.trim().isEmpty()) {
            logger.info("POST /api/message endpoint cagrildi. Raw Body ile gonderilen isim: {}", bodyName);
            if ("TÜRKSAT".equalsIgnoreCase(bodyName)) {
                return "Merhaba TÜRKSAT! (Body)";
            } else {
                return "Merhaba " + bodyName + "! (Body)";
            }
        }

        if (name != null && !name.trim().isEmpty()) {
            logger.info("POST /api/message endpoint cagrildi. URL parametresi ile gonderilen isim: {}", name);
            if ("TÜRKSAT".equalsIgnoreCase(name)) {
                return "Merhaba TÜRKSAT! (Param)";
            } else {
                return "Merhaba " + name + "! (Param)";
            }
        }

        logger.error("Hatali istek: Isim yok.");
        throw new BadRequestException("Lütfen bir isim yazınız.");
    }
}
