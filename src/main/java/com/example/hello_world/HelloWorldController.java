package com.example.hello_world;

import com.example.hello_world.exception.BadRequestException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HelloWorldController {

    @GetMapping("/message")
    public String getGreeting() {
        return "Merhaba Dünya!";
    }

    @PostMapping("/message")
    public String postGreeting(@RequestBody(required = false) String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new BadRequestException("Lütfen bir isim yazınız.");
        }
        if ("TÜRKSAT".equalsIgnoreCase(name)) {
            return "Merhaba TÜRKSAT!";
        } else {
            return "Merhaba " + name + "!";
        }
    }
}
