package com.Theowns.controllers;

import com.Theowns.DAO.AuthenticationRequest;
import com.Theowns.config.TokenUtils;
import com.Theowns.models.ConductorModel;
import com.Theowns.models.UserModel;
import com.Theowns.repositories.UserRepository;
import com.Theowns.services.UserService;
import com.Theowns.services.exceptions.DuplicateException;
import com.Theowns.services.exceptions.ExceptionObjectNotFound;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class UserController {
    private final AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
public ResponseEntity<ResponseObject<?>> authenticate( @RequestBody AuthenticationRequest request) throws ExceptionObjectNotFound {
        authenticationManager
            .authenticate( new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword()));

        UserModel user = userRepository.findByEmail(request.getEmail())
            .orElseThrow(()->new ExceptionObjectNotFound("Usuario no encontrado"));

        if(user != null){
            return ResponseEntity.ok(new ResponseObject<String>(
                    "Se ha loggeado correctamente",
                    TokenUtils.createToken(user.getRole().name(),user.getEmail())));
        }

        return ResponseEntity.status(400).body(new ResponseObject<String>("Error! No loggeado","Ha ocurrido un error, comprueba tus credenciales"));
    }
}
