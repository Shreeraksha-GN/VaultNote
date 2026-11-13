package com.vaultnote.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vaultnote.service.HelloService;

@RestController 
public class HelloController {

    private HelloService helloService;

    public HelloController(HelloService helloService){
        this.helloService = helloService;
    }
    
    @GetMapping("/api/v1/hello")
    public Map<String, String> sayHello(){
        String message = helloService.getWelcomeMessage();

        return Map.of("message", message);

    }

}
