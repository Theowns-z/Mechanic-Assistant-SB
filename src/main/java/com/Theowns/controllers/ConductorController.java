package com.Theowns.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/conductor")
public class ConductorController {

    @GetMapping
    public ResponseEntity<String>  sayHello(){
        return ResponseEntity.ok("Hello from api");
    }


    @GetMapping("/saygoodbye")
    public ResponseEntity<String> sayGoodBye(){
        return ResponseEntity.ok("Good bye from api");
    }
}
