package api.example.simple_api.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class RootController {
    
    @GetMapping("/")
    public String home() {
        return "Welcome to simple API!";
    }
    
}
