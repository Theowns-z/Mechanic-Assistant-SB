package com.Theowns.controllers;

import com.Theowns.models.ConductorModel;
import com.Theowns.models.UserModel;
import com.Theowns.services.UserService;
import com.Theowns.services.exceptions.DuplicateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping()
    public ResponseEntity<UserModel> save(@RequestBody UserModel user) throws DuplicateException {
        return ResponseEntity.ok( userService.save(user));
    }
}
